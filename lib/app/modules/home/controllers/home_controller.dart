// File: app/modules/home/controllers/home_controller.dart
import 'package:get/get.dart';
// Removed UserLogin import as it's now handled by DashboardController
// import 'package:myapp1/app/data/models/user_login_model.dart';

class HomeController extends GetxController {
  // loggedInUser logic has been moved to DashboardController.
  // This controller can be used for any state specific to the HomeView shell itself.

  @override
  void onInit() {
    super.onInit();
    // If HomeView needs to receive arguments (e.g. user data to pass to DashboardView),
    // that logic would still reside here or be managed via a shared service.
    // For now, assuming DashboardController handles its own data fetching or argument reception.
  }
}