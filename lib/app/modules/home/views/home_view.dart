import 'package:flutter/material.dart';
import 'package:get/get.dart';

class HomeView extends StatelessWidget {
  const HomeView({super.key});

  Future<void> _logout() async {
    Get.offAllNamed('/login'); // go to login page
  }
  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context); // current theme

    return Scaffold(
      backgroundColor: theme.colorScheme.surface,
      body: SafeArea(
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Header
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 16.0, vertical: 10),
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Image.asset('assets/newlogo.jpeg', width: 60),
                    const SizedBox(width: 10),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            'लघु जल संसाधन विभाग',
                            style: theme.textTheme.titleMedium?.copyWith(
                              fontWeight: FontWeight.bold,
                              color: Colors.red,
                            ),
                            overflow: TextOverflow.ellipsis,
                            maxLines: 1, // Adjust if multi-line is preferred and fits
                          ),
                          Text(
                            'Minor Water Resources Department | Govt. of Bihar',
                            style: theme.textTheme.bodySmall,
                            overflow: TextOverflow.ellipsis,
                            maxLines: 2, // Adjust as needed
                          ),
                        ],
                      ),
                    ),
                    const SizedBox(width: 10), // Add some spacing before the button
                    ElevatedButton.icon(
                      onPressed: _logout,
                      icon: const Icon(Icons.logout, size: 18),
                      label: const Text("Logout"),
                      style: ElevatedButton.styleFrom(
                        foregroundColor: Colors.white,
                        backgroundColor: Colors.red,
                        padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 8),
                        textStyle: theme.textTheme.labelSmall, // Use a smaller text style for the button
                      ),
                    ),
                  ],
                ),
              ),
              // Add other body content below the header
              // Make sure to wrap any large content with Expanded or constrain their height
              const SizedBox(height: 20), // Example content
              // Add more content here as needed
            ],
          ),
        ),
      ),
    );
  }
}
