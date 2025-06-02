import 'package:get/get.dart';
import 'package:myapp1/app/data/models/user_login_model.dart';
import 'package:myapp1/app/services/auth_service.dart'; // Import AuthService
import 'package:flutter/material.dart'; // Import material.dart for AlertDialog
import '../../../routes/app_pages.dart'; // Import Routes

class DashboardController extends GetxController {
  final Rx<UserLogin?> loggedInUser = Rx<UserLogin?>(null);

  // Method for the button
  void reloadDataFromServer() {
    Get.dialog(
      AlertDialog(
        title: const Text('Sync Status'),
        content: const Text("Plantation Data Synced Successfully"),
        actions: [
          TextButton(
            onPressed: () => Get.back(),
            child: const Text('ठीक है'),
          ),
        ],
      ),
      barrierDismissible: false,
    );
    print("'सर्वर से डेटा लोड करें' button pressed. Dialog shows: Plantation Data Synced Successfully");
  }

  void logoutUser() {
    Get.find<AuthService>().logoutUser();
    Get.offAllNamed(Routes.LOGIN); // Navigate to login and clear stack
  }

  @override
  void onInit() {
    super.onInit();
    // Get user data from AuthService
    final authService = Get.find<AuthService>();
    loggedInUser.value = authService.currentUser.value;

    // Optional: Listen to changes in AuthService if the user can log out
    // from somewhere else and the dashboard needs to react.
    // authService.currentUser.listen((user) {
    //   loggedInUser.value = user;
    //   if (user == null) {
    //     // Handle logout on dashboard if necessary, e.g., navigate to login
    //     // Get.offAllNamed(Routes.LOGIN);
    //   }
    // });
  }

  // void increment() => count.value++; // To be removed
} 