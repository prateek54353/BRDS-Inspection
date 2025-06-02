import 'dart:math';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:shared_preferences/shared_preferences.dart';
// Removed http, device_info_plus, network_info_plus, ApiConfig, and model imports as they are not needed for local hardcoded login

import '../../../data/models/user_login_model.dart'; // Still need UserLogin for mock data structure
import '../../../services/auth_service.dart'; // Import AuthService
import '../../../routes/app_pages.dart'; // Import for Routes

class LoginController extends GetxController {
  final usernameController = TextEditingController();
  final passwordController = TextEditingController();
  final captchaController = TextEditingController();

  final isLoading = false.obs;
  final rememberMe = false.obs;
  final generatedCaptcha = ''.obs;
  final isFormFilled = false.obs; // This will be used for enabling/disabling login button

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
    isFormFilled.value =
        usernameController.text.isNotEmpty &&
        passwordController.text.isNotEmpty &&
        captchaController.text.isNotEmpty;
  }

  void generateCaptcha() {
    final random = Random();
    final newCode = (1000 + random.nextInt(9000)).toString();
    generatedCaptcha.value = newCode;
    captchaController.clear(); // Clear previous captcha entry
    _checkFormFilled(); // Re-evaluate form fill status
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
    // Captcha validation remains
    if (captchaController.text != generatedCaptcha.value) {
      Get.closeCurrentSnackbar(); // Dismiss existing snackbar
      Get.snackbar(
        'Login Failed',
        'Wrong Captcha Entered',
        snackPosition: SnackPosition.TOP,
        backgroundColor: Colors.red,
        colorText: Colors.white,
      );
      generateCaptcha(); // Regenerate captcha after failed attempt
      return;
    }

    isLoading.value = true;
    // Simulate a small delay like a real API call
    await Future.delayed(const Duration(milliseconds: 500));

    if (usernameController.text == '1234' && passwordController.text == '1234') {
      // --- Mock User Data --- 
      final mockUserDetails = UserDetail(
        name: 'Local Test ',
        distName: 'Local ',
        department: 'Local ',
        blockName: 'Local ',
        panchayatName: 'Local ',
        userId: '1234',
        email: 'localuser@example.com',
        mobileNo: '0000000000'
        // Add other fields as needed, they will be null if not provided
      );
      final mockUserLogin = UserLogin(
        authToken: 'MOCK_LOCAL_AUTH_TOKEN_12345',
        userId: '1234',
        status: 'Success',
        message: 'Login Successful (Local Mock)',
        userDetails: mockUserDetails,
      );
      // --- End Mock User Data ---

      // Store in AuthService
      Get.find<AuthService>().loginUser(mockUserLogin);

      SharedPreferences prefs = await SharedPreferences.getInstance();
      await prefs.setString('authToken', mockUserLogin.authToken!);
      if (rememberMe.value) {
        await prefs.setString('saved_username', usernameController.text);
        await prefs.setBool('remember_me', true);
      } else {
        await prefs.remove('saved_username');
        await prefs.setBool('remember_me', false);
      }

      Get.snackbar(
        'Login Successful',
        mockUserLogin.message ?? 'Welcome, ${mockUserLogin.userId}!',
        snackPosition: SnackPosition.BOTTOM,
        backgroundColor: Colors.green,
        colorText: Colors.white,
      );
      Get.offNamed(Routes.HOME); // Navigate without arguments
    } else {
      Get.closeCurrentSnackbar(); // Dismiss existing snackbar
      Get.snackbar(
          'Login Failed',
          'Invalid username or password. Use 1234/1234 for local login.',
          snackPosition: SnackPosition.TOP,
          backgroundColor: Colors.red,
          colorText: Colors.white);
    }
    isLoading.value = false;
  }
}