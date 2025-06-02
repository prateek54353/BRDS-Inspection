import 'package:flutter/material.dart'; // Added for TextEditingController
import 'package:get/get.dart';

// Assuming a model class like this exists. If not, we'll need to create it.
// If it's in a different path, please adjust the import.
// import 'package:myapp1/app/data/models/plantation_insp_details_model.dart';

// Placeholder for the actual model if not defined yet
class PlantationInspDetails {
  final String id;
  final String workCode;
  final String workName;
  final String financialYear;
  final String agencyName;
  final String lastInspection;
  // Add other relevant fields from your PlantationInspDetails_Request model

  PlantationInspDetails({
    required this.id,
    required this.workCode,
    required this.workName,
    required this.financialYear,
    required this.agencyName,
    required this.lastInspection,
  });
}

class UploadController extends GetxController {
  // Observable list to hold all plantation inspection details
  final RxList<PlantationInspDetails> _allPlantationInspDetailsList = <PlantationInspDetails>[].obs;
  
  // Observable list for displaying (filtered) details
  final RxList<PlantationInspDetails> plantationInspDetailsList = <PlantationInspDetails>[].obs;

  final RxBool isLoading = true.obs;
  final RxString searchTerm = ''.obs;
  late TextEditingController searchController;

  String? userID; // Placeholder for userID

  @override
  void onInit() {
    super.onInit();
    searchController = TextEditingController();
    searchController.addListener(() {
      searchTerm.value = searchController.text;
    });
    // Filter list whenever searchTerm or the base list changes
    debounce(searchTerm, (_) => _filterPlantationDetails(), time: const Duration(milliseconds: 300));
    _allPlantationInspDetailsList.listen((_) => _filterPlantationDetails());
    
    fetchPlantationDetails();
  }

  Future<void> fetchPlantationDetails() async {
    try {
      isLoading.value = true;
      await Future.delayed(const Duration(seconds: 1)); 

      final List<PlantationInspDetails> dummyData = [
        PlantationInspDetails(
            id: '1',
            workCode: '0517001033/DP/20258099',
            workName: 'MURARI KUMAR / RAMCHATRA SINGH KE NIJI JAMIN PAR PLANTATION KARYA',
            financialYear: '2018-2019',
            agencyName: 'Gram Panchayat',
            lastInspection: 'Last Inspection Zero'),
        PlantationInspDetails(
            id: '2',
            workCode: '0517001033/DP/20258484',
            workName: 'USHA DEVI /NAWAL KISHOR SINGH KE NIJI JAMIN PAR PLANTATION KARYA',
            financialYear: '2018-2019',
            agencyName: 'Gram Panchayat',
            lastInspection: 'Last Inspection Zero'),
        PlantationInspDetails(
            id: '3',
            workCode: '0517001033/DP/20258488',
            workName: 'SAROJKUMARI / VIJAY KUMAR SINGH KE NIJI JAMIN PAR PLANTATION KARYA',
            financialYear: '2018-2019',
            agencyName: 'Gram Panchayat',
            lastInspection: 'Last Inspection Zero'),
        PlantationInspDetails( // Added one more for variety
            id: '4',
            workCode: '0517001033/DP/20258500',
            workName: 'ANOTHER SITE / TEST PLANTATION WORK',
            financialYear: '2019-2020',
            agencyName: 'Nagar Nigam',
            lastInspection: 'Inspection Pending'),
      ];
      
      _allPlantationInspDetailsList.assignAll(dummyData);
      // _filterPlantationDetails(); // Called by the listener

    } catch (e) {
      Get.snackbar('Error', 'Failed to fetch details: ${e.toString()}');
      _allPlantationInspDetailsList.clear();
      // _filterPlantationDetails(); // Called by the listener
    } finally {
      isLoading.value = false;
    }
  }

  void _filterPlantationDetails() {
    final query = searchTerm.value.toLowerCase();
    if (query.isEmpty) {
      plantationInspDetailsList.assignAll(_allPlantationInspDetailsList);
    } else {
      plantationInspDetailsList.assignAll(_allPlantationInspDetailsList.where((item) {
        return item.workCode.toLowerCase().contains(query) ||
               item.workName.toLowerCase().contains(query) ||
               item.financialYear.toLowerCase().contains(query) ||
               item.agencyName.toLowerCase().contains(query);
      }).toList());
    }
  }
  
  @override
  void onClose() {
    searchController.dispose();
    super.onClose();
  }
} 