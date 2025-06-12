import 'package:flutter/material.dart';
import 'package:get/get.dart';

// Data model for information passed from ReportView
class ReportListItemData {
  final String workCode;
  final String workName;
  final String workType;
  final String agencyName;
  final String financialYear;
  // Add any other relevant fields from your report entry model

  ReportListItemData({
    required this.workCode,
    required this.workName,
    required this.workType,
    required this.agencyName,
    required this.financialYear,
  });

  // Optional: Factory constructor if you want to pass a Map as arguments
  factory ReportListItemData.fromMap(Map<String, dynamic> map) {
    return ReportListItemData(
      workCode: map['workCode'] ?? 'N/A',
      workName: map['workName'] ?? 'N/A',
      workType: map['workType'] ?? 'N/A',
      agencyName: map['agencyName'] ?? 'N/A',
      financialYear: map['financialYear'] ?? 'N/A',
    );
  }
}

class InspectionFormController extends GetxController {
  final Rx<ReportListItemData?> reportData = Rx<ReportListItemData?>(null);

  // TextEditingControllers for the form fields based on the screenshot
  final siteSelectionController = TextEditingController(); // For "वृक्षारोपण का स्थल"
  final plantedSaplingsController = TextEditingController(); // "रोपित पौधों की संख्या"
  final survivedSaplingsController = TextEditingController(); // "उत्तरजीवित पौधों की संख्या"
  final survivalPercentageController = TextEditingController(); // "उत्तरजीविता प्रतिशत"
  final vanposhakCountController = TextEditingController(); // "वनपोषक की संख्या"
  final replacedSaplingsController = TextEditingController(); // "मृत पौधों के स्थान पर प्रतिस्थापित पौधों की संख्या"
  final vanposhakPaymentController = TextEditingController(); // For "वनपोषक का अध्ययन भुगतान"
  final averagePlantHeightController = TextEditingController(); // "पौधे की औसत ऊंचाई"
  final remarksController = TextEditingController(); // For "अभ्युक्ति"
  
  // Example for managing dropdown selected values
  final Rx<String?> selectedSite = Rx<String?>(null);
  final Rx<String?> selectedMonth = Rx<String?>(null); // New: For Month dropdown
  final Rx<String?> selectedYear = Rx<String?>(null); // New: For Year dropdown

  // Location related state
  final RxBool isLocationCaptured = false.obs;
  final RxString capturedLocationCoordinates = ''.obs;

  // To ensure we only calculate if both fields have valid numbers
  final RxBool canCalculateSurvivalRate = false.obs;

  final isLoading = false.obs;

  final Rx<String?> selectedVanposhakPaymentStatus = Rx<String?>(null);
  final Rx<String?> selectedVanposhakPaymentStatus2 = Rx<String?>(null); // For the second payment dropdown
  final Rx<String?> selectedType = Rx<String?>(null); // New: For "वृक्षारोपण का प्रकार" dropdown

  @override
  void onInit() {
    super.onInit();
    final dynamic arguments = Get.arguments;
    if (arguments != null && arguments is ReportListItemData) {
      reportData.value = arguments;
    } else if (arguments != null && arguments is Map<String, dynamic>){
      reportData.value = ReportListItemData.fromMap(arguments);
    }

    // Add listeners for survival percentage calculation
    plantedSaplingsController.addListener(_calculateSurvivalPercentage);
    survivedSaplingsController.addListener(_calculateSurvivalPercentage);
    // Initial check
    _checkCanCalculateSurvivalRate(); 
  }

  void _checkCanCalculateSurvivalRate() {
    final plantedText = plantedSaplingsController.text;
    final survivedText = survivedSaplingsController.text;
    canCalculateSurvivalRate.value = int.tryParse(plantedText) != null && int.tryParse(survivedText) != null;
  }

  void _calculateSurvivalPercentage() {
    _checkCanCalculateSurvivalRate(); // Update ability to calculate
    final plantedVal = int.tryParse(plantedSaplingsController.text);
    final survivedVal = int.tryParse(survivedSaplingsController.text);

    if (plantedVal != null && plantedVal > 0 && survivedVal != null && survivedVal >= 0) {
      if (survivedVal > plantedVal) {
        // Optional: Show a warning or cap survivedVal at plantedVal for percentage calculation
        // For now, let's allow it but it might lead to >100%
      }
      double percentage = (survivedVal / plantedVal) * 100.0;
      survivalPercentageController.text = percentage.toStringAsFixed(2); // Format to 2 decimal places
    } else {
      survivalPercentageController.text = ''; // Clear if inputs are invalid or planted is 0
    }
  }

  void submitForm() async {
    isLoading.value = true;
    // Dummy submit logic for now
    print("Form Data:");
    print("Site Selection: ${selectedSite.value}");
    print("Planted Saplings: ${plantedSaplingsController.text}");
    print("Average Plant Height: ${averagePlantHeightController.text}");
    print("Remarks: ${remarksController.text}");
    print("Location Coordinates: ${capturedLocationCoordinates.value}");
    // ... print other values
    await Future.delayed(const Duration(seconds: 1));
    isLoading.value = false;
    Get.closeCurrentSnackbar(); // Dismiss existing snackbar
    Get.snackbar("Success", "Form data logged (dummy submission)", snackPosition: SnackPosition.BOTTOM);
    // Get.back(); // Optionally navigate back after submission
  }

  void takeLocation() {
    Get.dialog(
      AlertDialog(
        title: const Text('लोकेशन कैप्चर'),
        content: const Text('लोकेशन ली जा रही है... कृपया प्रतीक्षा करें।\n(यह एक प्लेसहोल्डर है)'), // Location is being taken... please wait. (This is a placeholder)
        actions: <Widget>[
          TextButton(
            child: const Text('ठीक है'), // OK
            onPressed: () {
              Get.back(); // Close the dialog
              // Simulate location capture
              capturedLocationCoordinates.value = 'अक्षांश: 25.5941, देशांतर: 85.1376 (प्लेसहोल्डर)'; // Latitude: 25.5941, Longitude: 85.1376 (Placeholder)
              isLocationCaptured.value = true;
              Get.snackbar(
                'लोकेशन', 
                'लोकेशन सफलतापूर्वक ले ली गई है।\n${capturedLocationCoordinates.value}', 
                snackPosition: SnackPosition.BOTTOM
              );
            },
          ),
        ],
      ),
      barrierDismissible: false, // User must tap button!
    );
  }

  @override
  void onClose() {
    siteSelectionController.dispose();
    plantedSaplingsController.removeListener(_calculateSurvivalPercentage); // Remove listener
    plantedSaplingsController.dispose();
    survivedSaplingsController.removeListener(_calculateSurvivalPercentage); // Remove listener
    survivedSaplingsController.dispose();
    survivalPercentageController.dispose();
    vanposhakCountController.dispose();
    replacedSaplingsController.dispose();
    vanposhakPaymentController.dispose();
    averagePlantHeightController.dispose();
    remarksController.dispose();
    super.onClose();
  }
} 