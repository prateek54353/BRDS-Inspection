import 'package:get/get.dart';
import 'package:myapp1/app/data/models/user_login_model.dart'; // Adjust path if needed

class AuthService extends GetxService {
  final Rx<UserLogin?> currentUser = Rx<UserLogin?>(null);

  bool get isLoggedIn => currentUser.value != null;

  // Call this after successful login
  void loginUser(UserLogin user) {
    currentUser.value = user;
  }

  // Call this on logout
  void logoutUser() {
    currentUser.value = null;
    // Potentially clear SharedPreferences related to auth token here too
    // Get.find<SharedPreferences>().remove('authToken'); // Example if SharedPreferences is a GetxService
  }

  // Optional: Method to load user from storage on app start if implementing session persistence
  // Future<void> tryAutoLogin() async { ... }

  Future<AuthService> init() async {
    // If you have session persistence, load user here
    // For now, it just initializes an empty user
    return this;
  }
} 