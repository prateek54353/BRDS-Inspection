import 'package:get/get.dart';
// Import for Colors

class OtherdistrictController extends GetxController {
  final RxString selectedDistrictName = 'अतिरिक्त प्रभार (अन्य क्षेत्र) सूची'.obs;

  @override
  void onInit() {
    super.onInit();
  }

  @override
  void onReady() {
    super.onReady();
  }

  @override
  void onClose() {
    super.onClose();
  }

  void selectDistrict(Map<String, String> district) {
    // For now, selecting any district just navigates back and updates the name
    selectedDistrictName.value = district['name']!; // Update selected name for AppBar
    Get.back(); // Close the district list/view after selection
  }
}
