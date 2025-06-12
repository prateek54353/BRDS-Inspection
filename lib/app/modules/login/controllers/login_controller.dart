import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'dart:math';

import '../../../routes/app_pages.dart';

class LoginController extends GetxController {
  final TextEditingController usernameController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();
  final TextEditingController captchaController = TextEditingController();

  final _isLoading = false.obs;
  final _isPasswordVisible = false.obs; // Added for password visibility
  final _generatedCaptcha = ''.obs;

  bool get isLoading => _isLoading.value;
  bool get isPasswordVisible => _isPasswordVisible.value;
  String get generatedCaptcha => _generatedCaptcha.value;

  @override
  void onInit() {
    super.onInit();
    generateCaptcha();
  }

  void togglePasswordVisibility() {
    _isPasswordVisible.value = !_isPasswordVisible.value;
  }

  void generateCaptcha() {
    final random = Random();
    _generatedCaptcha.value = (1000 + random.nextInt(9000)).toString();
    captchaController.clear();
  }

  void login() {
    if (usernameController.text == "1234" &&
        passwordController.text == "1234" &&
        captchaController.text == _generatedCaptcha.value) {
      Get.snackbar(
        "Success",
        "Login Successful!",
        snackPosition: SnackPosition.BOTTOM,
        backgroundColor: Colors.green,
        colorText: Colors.white,
      );
      Get.offAllNamed(Routes.DASHBOARD); // Navigate to dashboard on success
    } else {
      Get.snackbar(
        "Error",
        "Invalid username, password, or captcha. Please use 1234/1234.",
        snackPosition: SnackPosition.BOTTOM,
        backgroundColor: Colors.red,
        colorText: Colors.white,
      );
      generateCaptcha(); // Regenerate captcha on failure
    }
  }

  @override
  void onClose() {
    usernameController.dispose();
    passwordController.dispose();
    captchaController.dispose();
    super.onClose();
  }
}