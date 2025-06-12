import 'package:get/get.dart';
import '../../../routes/app_pages.dart'; // Import Routes for navigation
import 'package:flutter/material.dart'; // Import Colors
import '../../inspection_form/controllers/inspection_form_controller.dart'; // Import ReportListItemData if needed for arguments

class DashboardController extends GetxController {
  final RxMap<String, String> currentDisplayedUserInfo = {
    'name': 'Hardcoded User (1234)',
    'zilla': '1234',
    'prakhand': '1234',
    'panchayat': '1234',
    'vibhaag': '1234',
  }.obs; // Initial hardcoded values for the dashboard header

  // State to hold the context of the last selected other district
  final Rx<ReportListItemData?> _lastFetchedOtherDistrictReportData = Rx<ReportListItemData?>(null);
  final RxBool _isOtherDistrictDataFetched = false.obs; // This will track if data for this context has been fetched
  final RxString _activeDistrictSelectionName = 'अपने क्षेत्र में'.obs; // To track if an other district is active

  @override
  void onInit() {
    super.onInit();
  }

  // Method to be called by OtherdistrictController to update dashboard's context
  void setOtherDistrictContext(Map<String, String> districtDetails, ReportListItemData? reportData, bool isFetched) {
    _activeDistrictSelectionName.value = districtDetails['name']!;
    currentDisplayedUserInfo.value = { // Update dashboard info with new details
      'name': 'Hardcoded User (${districtDetails['name']})',
      'zilla': districtDetails['zilla']!,
      'prakhand': districtDetails['prakhand']!,
      'panchayat': districtDetails['panchayat']!,
      'vibhaag': districtDetails['vibhaag']!,
    };
    _lastFetchedOtherDistrictReportData.value = reportData;
    _isOtherDistrictDataFetched.value = isFetched;
  }

  void reloadDataFromServer() {
    Get.snackbar(
      "Mock Data Load",
      "Data refreshed from mock source!",
      snackPosition: SnackPosition.BOTTOM,
      backgroundColor: Colors.blueAccent,
      colorText: Colors.white,
    );
  }

  void navigateToReportWithDataCheck() {
    if (_activeDistrictSelectionName.value != 'अपने क्षेत्र में') {
      // An other district context is active
      if (!_isOtherDistrictDataFetched.value) {
        Get.snackbar(
          "Warning",
          "fetch data from server first",
          snackPosition: SnackPosition.BOTTOM,
          backgroundColor: Colors.yellow,
          colorText: Colors.black,
        );
      } else if (_lastFetchedOtherDistrictReportData.value != null) {
        // Data is fetched, navigate with mock data
        Get.toNamed(Routes.REPORT, arguments: _lastFetchedOtherDistrictReportData.value);
      } else {
        // Fallback if data is fetched but mock data is null (shouldn't happen with current logic)
        Get.snackbar(
          "Error",
          "Mock data not available, please re-fetch.",
          snackPosition: SnackPosition.BOTTOM,
          backgroundColor: Colors.red,
          colorText: Colors.white,
        );
      }
    } else {
      // Default case: no other district active, navigate to report without specific mock data
      Get.toNamed(Routes.REPORT);
    }
  }

  void logoutUser() {
    Get.defaultDialog(
      title: "पुष्टि करें", // "Confirm"
      content: Column(
        children: [
          Image.asset('assets/brds.jpg', height: 40), // Your logo, now placed above the text
          const SizedBox(height: 10),
          const Text(
            "कृपया लॉगआउट करने से पहले सभी निरीक्षण रिकॉर्ड अपलोड कर लें, अन्यथा आप उन रिकॉर्ड को खो सकते हैं",
            textAlign: TextAlign.center,
            style: TextStyle(fontSize: 16),
          ),
        ],
      ),
      actions: [
        TextButton(
          onPressed: () {
            Get.back(); // Dismiss dialog
          },
          child: const Text("नहीं", style: TextStyle(color: Colors.red)), // "No"
        ),
        TextButton(
          onPressed: () {
            Get.back(); // Dismiss dialog
            Get.snackbar(
              "Logout",
              "You have been logged out (mock)!",
              snackPosition: SnackPosition.BOTTOM,
              backgroundColor: Colors.orange,
              colorText: Colors.white,
            );
            Get.offAllNamed(Routes.LOGIN); // Navigate to login and clear stack
          },
          child: const Text("हाँ", style: TextStyle(color: Colors.green)), // "Yes"
        ),
      ],
    );
  }
}