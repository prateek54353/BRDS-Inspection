import 'package:flutter/material.dart';
import 'package:get/get.dart';
import '../controllers/login_controller.dart';
import 'package:myapp1/app/routes/app_pages.dart';

class LoginView extends GetView<LoginController> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Center(
          child: SingleChildScrollView(
            child: ConstrainedBox(
              constraints: BoxConstraints(
                maxWidth: 400,
                minHeight: MediaQuery.of(context).size.height,
              ),
              child: Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    // Logo
                    Image.asset(
                      'assets/newlogo.jpeg',
                      height: MediaQuery.of(context).size.height * 0.22, // Responsive image height
                      fit: BoxFit.contain,
                    ),

                    const SizedBox(height: 20),
                    TextFormField(
                      controller: controller.usernameController,
                      decoration: const InputDecoration(
                        labelText: 'Username',
                        prefixIcon: Icon(Icons.person),
                        border: OutlineInputBorder(),
                      ),
                    ),

                    const SizedBox(height: 8),

                    // Password input
                    TextField(
                      controller: controller.passwordController,
                      obscureText: true,
                      decoration: const InputDecoration(
                        labelText: "Enter Password",
                        prefixIcon: Icon(Icons.password),
                        border: OutlineInputBorder(),
                      ),
                    ),

                    const SizedBox(height: 8),

                    // Captcha Box
                    Obx(() => Row(
                      children: [
                        Container(
                          padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 8),
                          decoration: BoxDecoration(
                            color: Colors.black,
                            borderRadius: BorderRadius.circular(4),
                          ),
                          child: Text(
                            controller.generatedCaptcha.value,
                            style: const TextStyle(
                              color: Colors.yellow,
                              fontSize: 24,
                              fontStyle: FontStyle.italic,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                        ),
                        IconButton(
                          onPressed: controller.generateCaptcha,
                          icon: const Icon(Icons.refresh, color: Colors.amber, size: 30),
                        ),
                        Flexible(
                          child: TextField(
                            controller: controller.captchaController,
                            decoration: InputDecoration(
                              hintText: 'Enter Captcha',
                              border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(8),
                              ),
                            ),
                          ),
                        ),
                      ],
                    )),

                    const SizedBox(height: 16),

                    // Remember Me checkbox
                    Obx(() => CheckboxListTile(
                      contentPadding: EdgeInsets.zero,
                      title: const Text('Remember Me'),
                      value: controller.rememberMe.value,
                      onChanged: (value) {
                        controller.rememberMe.value = value!;
                      },
                    )),

                    // Forgot Password
                    Align(
                      alignment: Alignment.centerRight,
                      child: ElevatedButton(
                        onPressed: () {
                          Get.toNamed(Routes.FORGOT_PASSWORD);
                        },
                        style: ElevatedButton.styleFrom(
                          backgroundColor: const Color.fromRGBO(65, 101, 149, 1),
                          foregroundColor: Colors.white,
                          padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 0),
                          textStyle: const TextStyle(
                            fontSize: 10,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        child: const Text('Forgot Password'),
                      ),
                    ),

                    const SizedBox(height: 16),

                    // Login Button
                    Obx(() => ElevatedButton(
                      onPressed: controller.isFormFilled.value && !controller.isLoading.value
                          ? controller.login
                          : null,
                      style: ElevatedButton.styleFrom(
                        backgroundColor: const Color.fromRGBO(65, 101, 149, 1),
                        foregroundColor: Colors.white,
                        padding: const EdgeInsets.symmetric(horizontal: 100, vertical: 5),
                        textStyle: const TextStyle(
                          fontSize: 25,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      child: controller.isLoading.value
                          ? const CircularProgressIndicator()
                          : const Text('LOGIN'),
                    )),
                  ],
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
