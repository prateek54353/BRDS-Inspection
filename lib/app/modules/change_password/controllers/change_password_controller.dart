import 'package:get/get.dart';

class ChangePasswordController extends GetxController {
  final currentPassword = ''.obs;
  final newPassword = ''.obs;
  final confirmPassword = ''.obs;

  void updatePassword() {
    // TODO: Implement password update logic
    Get.snackbar(
      'Success',
      'Password updated successfully',
      snackPosition: SnackPosition.BOTTOM,
    );
  }
}
