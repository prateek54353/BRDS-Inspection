import 'package:get/get.dart';
import 'package:flutter/material.dart'; // For TextEditingController
import 'dart:math'; // For Random class to generate captcha

class ForgotpassController extends GetxController {
  final TextEditingController userIdController = TextEditingController();
  final TextEditingController mobileNumberController = TextEditingController();
  final TextEditingController captchaInputController = TextEditingController();

  final RxString generatedCaptcha = ''.obs;

  @override
  void onInit() {
    super.onInit();
    generateCaptcha();
  }

  @override
  void onReady() {
    super.onReady();
  }

  @override
  void onClose() {
    userIdController.dispose();
    mobileNumberController.dispose();
    captchaInputController.dispose();
    super.onClose();
  }

  void generateCaptcha() {
    final random = Random();
    // Generate a random 4-digit number and optionally a letter
    String captchaText = (1000 + random.nextInt(9000)).toString();
    if (random.nextBool()) {
      // 50% chance to add a random uppercase letter
      captchaText += String.fromCharCode(65 + random.nextInt(26));
    }
    generatedCaptcha.value = captchaText;
    captchaInputController.clear(); // Clear the input field when captcha refreshes
  }

  // No logic for continue button for now, as requested
  void onContinuePressed() {
    // This method is just a placeholder for the UI button, no logic needed for now.
    // Get.snackbar("Info", "Continue pressed - No logic implemented yet.");
  }
}
