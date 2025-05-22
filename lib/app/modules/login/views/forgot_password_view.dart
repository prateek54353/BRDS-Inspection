import 'package:flutter/material.dart';
import 'package:get/get.dart';
import '../controllers/login_controller.dart';

class ForgotPasswordView extends GetView<LoginController> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Forgot Password'),
        backgroundColor: const Color.fromRGBO(65, 101, 149, 1),
      ),
      body: SafeArea(
        child: SingleChildScrollView(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              const Text(
                'Reset Password',
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                ),
                textAlign: TextAlign.center,
              ),
              const SizedBox(height: 20),
              
              // Email input
              TextFormField(
                controller: controller.emailController,
                decoration: const InputDecoration(
                  labelText: 'Registered Email',
                  prefixIcon: Icon(Icons.email),
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.emailAddress,
              ),
              const SizedBox(height: 16),
              
              // Mobile Number input
              TextFormField(
                controller: controller.mobileController,
                decoration: const InputDecoration(
                  labelText: 'Registered Mobile Number',
                  prefixIcon: Icon(Icons.phone),
                  border: OutlineInputBorder(),
                ),
                keyboardType: TextInputType.phone,
              ),
              const SizedBox(height: 24),
              
              // Submit button
              ElevatedButton(
                onPressed: () {
                  if (controller.emailController.text.isEmpty && controller.mobileController.text.isEmpty) {
                    Get.snackbar(
                      'Error',
                      'Please enter either email or mobile number',
                      backgroundColor: Colors.red,
                      colorText: Colors.white,
                    );
                    return;
                  }
                  // TODO: Implement password reset logic
                  Get.snackbar(
                    'Success',
                    'Password reset instructions have been sent',
                    backgroundColor: Colors.green,
                    colorText: Colors.white,
                  );
                  Get.back();
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: const Color.fromRGBO(65, 101, 149, 1),
                  padding: const EdgeInsets.symmetric(vertical: 16),
                ),
                child: const Text(
                  'Send Reset Instructions',
                  style: TextStyle(fontSize: 16),
                ),
              ),
              const SizedBox(height: 16),
              
              // Back to login button
              TextButton(
                onPressed: () {
                  Get.back();
                },
                child: const Text(
                  'Back to Login',
                  style: TextStyle(color: Colors.grey),
                ),
              ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
