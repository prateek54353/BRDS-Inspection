import 'package:flutter/material.dart';

import 'package:get/get.dart';

import '../controllers/forgotpass_controller.dart';

class ForgotpassView extends GetView<ForgotpassController> {
  const ForgotpassView({super.key});

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    const Color _persistentGreen = Color(0xFF295C46); // A dark green from previous designs
    const Color _persistentWhite = Colors.white;

    return Scaffold(
      appBar: AppBar(
        backgroundColor: theme.colorScheme.primaryContainer,
        foregroundColor: theme.colorScheme.onPrimaryContainer,
        elevation: 0,
        leading: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Image.asset('assets/brds.jpg', height: 40), // Your logo
        ),
        title: const Text(
          'BRDS Inspection',
          style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
        ),
        centerTitle: true,
        actions: <Widget>[
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Image.asset('assets/govbihar.png', height: 40), // Your govbihar logo
          ),
        ],
        bottom: PreferredSize(
          preferredSize: const Size.fromHeight(1.0),
          child: Container(
            color: theme.colorScheme.outline.withAlpha((255 * 0.5).round()),
            height: 1.0,
          ),
        ),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(24.0), // Increased padding for better spacing
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Center(
              child: Column(
                children: [
                  Image.asset(
                    'assets/bid_logo.jpg', // Assuming this is the top logo
                    height: 80, // Adjust size as needed
                  ),
                  const SizedBox(height: 8),
                  Text(
                    'सुखी गांव, संपन्न बिहार', // Hindi text from image
                    style: theme.textTheme.bodyMedium?.copyWith(color: Colors.grey[700]),
                  ),
                ],
              ),
            ),
            const SizedBox(height: 40),
            Text(
              'Reset Your Password',
              style: theme.textTheme.headlineSmall?.copyWith(
                fontWeight: FontWeight.bold,
                color: _persistentGreen,
              ),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 30),
            _buildTextField(controller.userIdController, 'User ID', theme),
            const SizedBox(height: 20),
            _buildTextField(controller.mobileNumberController, 'Mobile Number', theme),
            const SizedBox(height: 20),
            Row(
              children: [
                Expanded(
                  child: Obx(() => Container(
                        padding: const EdgeInsets.symmetric(vertical: 12, horizontal: 8),
                        decoration: BoxDecoration(
                          color: Colors.blueAccent.withOpacity(0.8), // Blue gradient from image
                          borderRadius: BorderRadius.circular(10),
                          border: Border.all(color: Colors.blueAccent, width: 1.5),
                        ),
                        child: FittedBox(
                          fit: BoxFit.scaleDown,
                          child: Text(
                            controller.generatedCaptcha.value,
                            style: theme.textTheme.headlineSmall?.copyWith(
                              color: Colors.white,
                              fontWeight: FontWeight.bold,
                            ),
                            textAlign: TextAlign.center,
                          ),
                        ),
                      ),
                  ),
                ),
                const SizedBox(width: 10),
                IconButton(
                  icon: Icon(Icons.refresh, color: Colors.grey[600]),
                  onPressed: controller.generateCaptcha,
                ),
                const SizedBox(width: 10),
                Expanded(
                  flex: 2,
                  child: _buildTextField(controller.captchaInputController, 'Enter Captcha', theme),
                ),
              ],
            ),
            const SizedBox(height: 30),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color(0xFFA5D6A7), // Light green for continue button
                foregroundColor: _persistentWhite,
                padding: const EdgeInsets.symmetric(vertical: 16),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
                elevation: 5,
              ),
              onPressed: controller.onContinuePressed, // Placeholder for now
              child: Text(
                'Continue',
                style: theme.textTheme.titleLarge?.copyWith(color: _persistentWhite, fontWeight: FontWeight.bold),
              ),
            ),
            const SizedBox(height: 40), // Spacer for bottom text
          ],
        ),
      ),
      bottomNavigationBar: BottomAppBar(
        color: _persistentGreen,
        child: SizedBox(
          height: 40,
          child: Center(
            child: Text(
              'Services provided by: NIC Bihar',
              style: theme.textTheme.bodyMedium?.copyWith(color: _persistentWhite),
            ),
          ),
        ),
      ),
    );
  }

  Widget _buildTextField(TextEditingController controller, String labelText, ThemeData theme) {
    return TextField(
      controller: controller,
      decoration: InputDecoration(
        labelText: labelText,
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(10),
        ),
        enabledBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(10),
          borderSide: BorderSide(color: Colors.grey[300]!),
        ),
        focusedBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(10),
          borderSide: BorderSide(color: theme.colorScheme.primary, width: 2),
        ),
      ),
    );
  }
}
