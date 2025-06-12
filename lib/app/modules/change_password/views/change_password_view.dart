import 'package:flutter/material.dart';
import 'package:get/get.dart';
import '../controllers/change_password_controller.dart';

class ChangePasswordView extends GetView<ChangePasswordController> {
  const ChangePasswordView({super.key});

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    const Color _persistentGreen = Color(0xFF295C46);
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
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            const SizedBox(height: 20),
            Align(
              alignment: Alignment.center,
              child: Text(
                'Change Password',
                style: theme.textTheme.headlineSmall?.copyWith(
                  fontWeight: FontWeight.bold,
                  color: _persistentGreen,
                ),
              ),
            ),
            const SizedBox(height: 30),
            Card(
              color: _persistentGreen,
              margin: EdgeInsets.zero,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(10),
              ),
              child: Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  children: [
                    Text(
                      'User Name',
                      style: theme.textTheme.bodyLarge?.copyWith(color: _persistentWhite),
                      textAlign: TextAlign.center,
                    ),
                    const SizedBox(height: 8),
                    Text(
                      'Mahtab Alam', // Hardcoded user name as per image
                      style: theme.textTheme.headlineSmall?.copyWith(
                        color: _persistentWhite,
                        fontWeight: FontWeight.bold,
                      ),
                      textAlign: TextAlign.center,
                    ),
                  ],
                ),
              ),
            ),
            const SizedBox(height: 20),
            _PasswordField(
              controller: controller.oldPasswordController,
              labelText: 'Enter Old Password',
            ),
            const SizedBox(height: 16),
            _PasswordField(
              controller: controller.newPasswordController,
              labelText: 'Enter New Password',
            ),
            const SizedBox(height: 16),
            _PasswordField(
              controller: controller.confirmPasswordController,
              labelText: 'Enter Confirm Password',
            ),
            const SizedBox(height: 24),
            ElevatedButton(
              style: ElevatedButton.styleFrom(
                backgroundColor: _persistentGreen,
                foregroundColor: _persistentWhite,
                padding: const EdgeInsets.symmetric(vertical: 16),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
              onPressed: () {
                // No logic for now
              },
              child: const Text(
                'Save and Update',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
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
}

class _PasswordField extends StatefulWidget {
  final TextEditingController controller;
  final String labelText;

  const _PasswordField({
    required this.controller,
    required this.labelText,
  });

  @override
  State<_PasswordField> createState() => _PasswordFieldState();
}

class _PasswordFieldState extends State<_PasswordField> {
  bool _obscureText = true;

  void _toggleVisibility() {
    setState(() {
      _obscureText = !_obscureText;
    });
  }

  @override
  Widget build(BuildContext context) {
    return TextField(
      controller: widget.controller,
      obscureText: _obscureText,
      decoration: InputDecoration(
        labelText: widget.labelText,
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(10),
          borderSide: const BorderSide(color: Color(0xFFE0E0E0), width: 1.0),
        ),
        enabledBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(10),
          borderSide: const BorderSide(color: Color(0xFFE0E0E0), width: 1.0),
        ),
        focusedBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(10),
          borderSide: const BorderSide(color: Color(0xFF295C46), width: 2.0),
        ),
        suffixIcon: IconButton(
          icon: Icon(
            _obscureText ? Icons.visibility_off : Icons.visibility,
            color: Colors.grey,
          ),
          onPressed: _toggleVisibility,
        ),
      ),
    );
  }
}
