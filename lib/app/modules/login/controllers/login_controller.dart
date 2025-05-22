import 'dart:convert';
import 'dart:math';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:http/http.dart' as http;

class LoginController extends GetxController {
  final usernameController = TextEditingController();
  final passwordController = TextEditingController();
  final captchaController = TextEditingController();
  final emailController = TextEditingController();
  final mobileController = TextEditingController();

  final isLoading = false.obs;
  final rememberMe = false.obs;
  final generatedCaptcha = ''.obs;
  final isFormFilled = false.obs;

  @override
  void onInit() {
    super.onInit();
    loadUsername();
    generateCaptcha();
    _setupListeners();
  }

  void _setupListeners() {
    usernameController.addListener(_checkFormFilled);
    passwordController.addListener(_checkFormFilled);
    captchaController.addListener(_checkFormFilled);
  }

  void _checkFormFilled() {
    isFormFilled.value = usernameController.text.isNotEmpty &&
        passwordController.text.isNotEmpty &&
        captchaController.text.isNotEmpty;
  }

  void generateCaptcha() {
    final random = Random();
    final newCode = (1000 + random.nextInt(9000)).toString();
    generatedCaptcha.value = newCode;
    captchaController.clear();
    _checkFormFilled();
  }

  Future<void> loadUsername() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    final savedUsername = prefs.getString('saved_username') ?? '';
    final savedFlag = prefs.getBool('remember_me') ?? false;

    rememberMe.value = savedFlag;
    if (savedFlag) {
      usernameController.text = savedUsername;
    }
  }

  Future<void> login() async {
    isLoading.value = true;

    // simulate delay to match splash screen or backend
    await Future.delayed(const Duration(seconds: 2));

    if (captchaController.text != generatedCaptcha.value) {
      Get.snackbar(
        'Login Failed',
        'Wrong Captcha Entered',
        snackPosition: SnackPosition.TOP,
        backgroundColor: Colors.red,
        colorText: Colors.white,
        duration: const Duration(seconds: 2),
      );
      generateCaptcha();
      isLoading.value = false;
      return;
    }

    try {
      final response = await http.get(
        Uri.parse('https://682c1fc5d29df7a95be591c1.mockapi.io/users'),
      );

      if (response.statusCode == 200) {
        final List users = json.decode(response.body);
        final matchedUser = users.firstWhereOrNull((user) =>
        user['username'] == usernameController.text &&
            user['password'] == passwordController.text);

        if (matchedUser != null) {
          SharedPreferences prefs = await SharedPreferences.getInstance();
          if (rememberMe.value) {
            await prefs.setString('saved_username', usernameController.text);
            await prefs.setBool('remember_me', true);
          } else {
            await prefs.remove('saved_username');
            await prefs.setBool('remember_me', false);
          }

          Get.snackbar(
            'Login Successful',
            'Welcome, ${matchedUser['username']}!',
            snackPosition: SnackPosition.BOTTOM,
            backgroundColor: Colors.green,
            colorText: Colors.white,
            duration: const Duration(seconds: 1),
          );
          Get.offNamed('/home');
        } else {
          Get.snackbar(
            'Login Failed',
            'Invalid username or password',
            snackPosition: SnackPosition.TOP,
            backgroundColor: Colors.red,
            colorText: Colors.white,
            duration: const Duration(seconds: 2),
          );
        }
      } else {
        Get.snackbar(
          'Server Error',
          'Failed to fetch user data',
          snackPosition: SnackPosition.TOP,
          backgroundColor: Colors.orange,
          colorText: Colors.white,
          duration: const Duration(seconds: 2),
        );
      }
    } catch (e) {
      Get.snackbar(
        'Error',
        'An unexpected error occurred',
        snackPosition: SnackPosition.TOP,
        backgroundColor: Colors.red,
        colorText: Colors.white,
        duration: const Duration(seconds: 2),
      );
    } finally {
      isLoading.value = false;
    }
  }
}
