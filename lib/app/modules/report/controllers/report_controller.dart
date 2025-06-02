import 'package:flutter/material.dart';
import 'package:get/get.dart';

class PlantationInspDetails {
  final String id;
  final String workCode;
  final String workName;
  final String financialYear;
  final String agencyName;
  final String lastInspection;

  PlantationInspDetails({
    required this.id,
    required this.workCode,
    required this.workName,
    required this.financialYear,
    required this.agencyName,
    required this.lastInspection,
  });
}


class ReportController extends GetxController {
  final RxList<PlantationInspDetails> _allPlantationInspDetailsList = <PlantationInspDetails>[].obs;
  final RxList<PlantationInspDetails> plantationInspDetailsList = <PlantationInspDetails>[].obs;
  final RxBool isLoading = true.obs;
  final RxString searchTerm = ''.obs;
  late TextEditingController searchController;
  String? userID;

  @override
  void onInit() {
    super.onInit();
    searchController = TextEditingController();
    searchController.addListener(() {
      searchTerm.value = searchController.text;
    });
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
        PlantationInspDetails(
            id: '4',
            workCode: '0517001033/DP/20258500',
            workName: 'ANOTHER SITE / TEST PLANTATION WORK',
            financialYear: '2019-2020',
            agencyName: 'Nagar Nigam',
            lastInspection: 'Inspection Pending'),
      ];
      _allPlantationInspDetailsList.assignAll(dummyData);
    } catch (e) {
      Get.snackbar('Error', 'Failed to fetch details: \\${e.toString()}');
      _allPlantationInspDetailsList.clear();
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