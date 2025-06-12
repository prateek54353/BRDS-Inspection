import 'package:flutter/material.dart';
import 'package:get/get.dart';
import '../controllers/report_controller.dart';
import '../../../widgets/app_header.dart';
import '../../../routes/app_pages.dart'; // Corrected: Import app_pages.dart which includes app_routes.dart as a part
import '../../inspection_form/controllers/inspection_form_controller.dart' show ReportListItemData;

class ReportView extends GetView<ReportController> {
  const ReportView({super.key});

  @override
  Widget build(BuildContext context) {
    final ThemeData theme = Theme.of(context); // Access theme for colors if needed

    return Scaffold(
      appBar: null,
      body: SafeArea(
        child: Column(
          children: [
            const AppHeader(),
            // New Title Bar
            Obx(() { 
                return Container(
                  width: double.infinity,
                  color: const Color(0xFF003d21), // Dark green background from screenshot
                  padding: const EdgeInsets.symmetric(vertical: 10.0, horizontal: 16.0),
                  child: Text(
                    'वृक्षारोपण उत्तरजीविता प्रतिवेदन (${controller.plantationInspDetailsList.length})',
                    style: const TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                      fontWeight: FontWeight.w500,
                    ),
                    textAlign: TextAlign.center,
                    maxLines: 2,
                    overflow: TextOverflow.ellipsis,
                  ),
                );
              }
            ),
            Expanded(
              child: Column(
                children: [
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Row(
                      children: [
                        Expanded(
                          child: TextField(
                            controller: controller.searchController,
                            decoration: InputDecoration(
                              hintText: 'Search...',
                              prefixIcon: const Icon(Icons.search),
                              border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(8.0),
                                borderSide: const BorderSide(color: Colors.grey),
                              ),
                              filled: true,
                              fillColor: theme.inputDecorationTheme.fillColor ?? theme.colorScheme.surface, // Use theme
                              contentPadding: const EdgeInsets.symmetric(vertical: 0, horizontal: 10),
                            ),
                          ),
                        ),
                        const SizedBox(width: 8),
                        ElevatedButton(
                          style: ElevatedButton.styleFrom(
                            backgroundColor: theme.colorScheme.primaryContainer,
                            foregroundColor: theme.colorScheme.onPrimaryContainer,
                            padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 12),
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(8.0),
                            ),
                          ),
                          onPressed: () {
                            FocusScope.of(context).unfocus();
                          },
                          child: const Text('SEARCH'),
                        ),
                      ],
                    ),
                  ),
                  Expanded(
                    child: Obx(() {
                      if (controller.isLoading.value) {
                        return const Center(child: CircularProgressIndicator());
                      }
                      if (controller.plantationInspDetailsList.isEmpty) {
                        return Center(
                          child: Text(
                            'कोई रिकॉर्ड नहीं मिला',
                            style: TextStyle(fontSize: 18, color: theme.disabledColor),
                          ),
                        );
                      }
                      return ListView.builder(
                        padding: const EdgeInsets.symmetric(horizontal: 8.0),
                        itemCount: controller.plantationInspDetailsList.length,
                        itemBuilder: (context, index) {
                          final item = controller.plantationInspDetailsList[index];
                          return GestureDetector( // Wrap Card with GestureDetector
                            onTap: () {
                              // Create ReportListItemData from the tapped item
                              final reportItemData = ReportListItemData(
                                workCode: item.workCode,
                                workName: item.workName,
                                // Assuming PlantationInspDetails doesn't have workType, 
                                // you might need to adjust or pass a default/placeholder
                                workType: item.workName.contains('NIJI') ? 'Private Land' : 'Gov building Block Plantation-Farm Forestry-Comm', // Example logic for workType based on workName
                                agencyName: item.agencyName,
                                financialYear: item.financialYear,
                              );
                              // Navigate to the  form
                              Get.toNamed(Routes.INSPECTION_FORM, arguments: reportItemData);
                            },
                            child: Card(
                              margin: const EdgeInsets.symmetric(vertical: 6.0),
                              color: const Color(0xFFE8F5E9), // Light green background for the card
                              elevation: 2,
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(4),
                                side: BorderSide(color: theme.dividerColor.withAlpha((255 * 0.5).round()), width: 0.5),
                              ),
                              child: Padding(
                                padding: const EdgeInsets.all(12.0),
                                child: Column(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    _buildDetailRow('Work Code', item.workCode, context),
                                    _buildDetailRow('Work Name', item.workName, context, isWorkName: true),
                                    _buildDetailRow('Financial Year', item.financialYear, context),
                                    _buildDetailRow('Agency Name', item.agencyName, context),
                                    _buildDetailRow('Last Inspection', item.lastInspection, context),
                                  ],
                                ),
                              ),
                            ),
                          );
                        },
                      );
                    }),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }


  Widget _buildDetailRow(String label, String value, BuildContext context, {bool isWorkName = false}) {
    final ThemeData theme = Theme.of(context);
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 2.5),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          SizedBox(
            width: 110,
            child: Text(
              '$label:',
              style: theme.textTheme.labelLarge?.copyWith(color: Colors.grey[700]), // Darker grey for label for better readability on light green
            ),
          ),
          const SizedBox(width: 8),
          Expanded(
            child: Text(
              value,
              style: theme.textTheme.bodyMedium?.copyWith(
                fontWeight: isWorkName ? FontWeight.w500 : FontWeight.normal,
                color: Colors.black87, // Black/dark gray for value text
              ),
            ),
          ),
        ],
      ),
    );
  }
} 