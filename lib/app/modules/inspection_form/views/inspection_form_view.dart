import 'package:flutter/material.dart';
import 'package:get/get.dart';
import '../controllers/inspection_form_controller.dart';

class InspectionFormView extends GetView<InspectionFormController> {
  const InspectionFormView({super.key});

  Widget _buildInfoCard(ReportListItemData data, BuildContext context) {
    final theme = Theme.of(context);
    return Card(
      color: theme.colorScheme.primaryContainer.withOpacity(0.2), // Themed background
      margin: const EdgeInsets.only(bottom: 20.0),
      elevation: 1, // Reduced elevation for a flatter look with themed background
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
      child: Padding(
        padding: const EdgeInsets.all(12.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            _buildInfoRow('Work Code', data.workCode, context),
            _buildInfoRow('Work Name', data.workName, context),
            _buildInfoRow('Work Type', data.workType, context),
            _buildInfoRow('Agency Name', data.agencyName, context),
            _buildInfoRow('Financial Year', data.financialYear, context),
          ],
        ),
      ),
    );
  }

  Widget _buildInfoRow(String label, String value, BuildContext context) {
    final theme = Theme.of(context);
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 4.0),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Expanded(flex: 2, child: Text('$label:', style: theme.textTheme.titleSmall?.copyWith(fontWeight: FontWeight.bold, color: theme.colorScheme.onSurfaceVariant))),
          Expanded(flex: 3, child: Text(value, style: theme.textTheme.titleSmall?.copyWith(color: theme.colorScheme.onSurfaceVariant))),
        ],
      ),
    );
  }

  Widget _buildTextField({
    required TextEditingController controller,
    required String labelText,
    TextInputType keyboardType = TextInputType.text,
    bool isMandatory = true,
    bool isReadOnly = false,
  }) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: TextFormField(
        controller: controller,
        readOnly: isReadOnly,
        decoration: InputDecoration(
          labelText: labelText + (isMandatory ? ' *' : ''),
          border: const OutlineInputBorder(),
          contentPadding: const EdgeInsets.symmetric(horizontal: 12, vertical: 16),
          fillColor: isReadOnly ? Colors.grey[200] : null,
          filled: isReadOnly,
        ),
        keyboardType: keyboardType,
      ),
    );
  }

 Widget _buildDropdownField({
    required Rx<String?>selectedValueController, // Controller to hold the selected value
    required String labelText,
    required List<String> items, // List of items for the dropdown
    String? hintText = '-चयन-', // Hint text for the dropdown
    bool isMandatory = true,
  }) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: Obx(() => DropdownButtonFormField<String>(
            decoration: InputDecoration(
              labelText: labelText + (isMandatory ? ' *' : ''),
              border: const OutlineInputBorder(),
              contentPadding: const EdgeInsets.symmetric(horizontal: 12, vertical: 4), // Adjusted padding for dropdown
            ),
            value: selectedValueController.value,
            hint: hintText != null ? Text(hintText) : null,
            isExpanded: true,
            onChanged: (String? newValue) {
              selectedValueController.value = newValue;
            },
            items: items.map<DropdownMenuItem<String>>((String value) {
              return DropdownMenuItem<String>(
                value: value,
                child: Text(value),
              );
            }).toList(),
          )),
    );
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context); // Get theme here
    // Dummy items for dropdowns - replace with actual data sources
    final List<String> siteOptions = ['Site A', 'Site B', 'Site C', 'Other']; 
    final List<String> paymentOptions = ['Paid', 'Pending', 'Not Applicable'];

    return Scaffold(
      appBar: AppBar(
        title: const Text('BRDS Inspection', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
        centerTitle: true,
        elevation: 1,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            // Display received report data
            Obx(() {
              if (controller.reportData.value == null) {
                return const Center(child: Text("No report data found."));
              }
              return _buildInfoCard(controller.reportData.value!, context);
            }),
            
            Text('वृक्षारोपण उत्तरजीविता प्रतिवेदन', style: theme.textTheme.titleMedium?.copyWith(fontWeight: FontWeight.bold)),
            const SizedBox(height:16),

            _buildDropdownField(
              selectedValueController: controller.selectedSite,
              labelText: 'वृक्षारोपण का स्थल',
              items: siteOptions, 
            ),
            _buildTextField(
              controller: controller.plantedSaplingsController,
              labelText: 'रोपित पौधों की संख्या',
              keyboardType: TextInputType.number,
            ),
            _buildTextField(
              controller: controller.survivedSaplingsController,
              labelText: 'उत्तरजीवित पौधों की संख्या',
              keyboardType: TextInputType.number,
            ),
            _buildTextField(
              controller: controller.survivalPercentageController,
              labelText: 'उत्तरजीविता प्रतिशत',
              keyboardType: TextInputType.numberWithOptions(decimal: true),
              isReadOnly: true,
            ),
            _buildTextField(
              controller: controller.vanposhakCountController,
              labelText: 'वनपोषक की संख्या',
              keyboardType: TextInputType.number,
            ),
            _buildTextField(
              controller: controller.replacedSaplingsController,
              labelText: 'मृत पौधों के स्थान पर प्रतिस्थापित पौधों की संख्या',
              keyboardType: TextInputType.number,
            ),
            _buildDropdownField(
              selectedValueController: controller.selectedVanposhakPaymentStatus,
              labelText: 'वनपोषक का अध्ययन भुगतान',
              items: paymentOptions,
            ),
            _buildTextField(
              controller: controller.averagePlantHeightController,
              labelText: 'पौधे की औसत ऊंचाई (फीट में)', // Added unit for clarity
              keyboardType: TextInputType.numberWithOptions(decimal: true),
            ),
            _buildTextField(
              controller: controller.remarksController,
              labelText: 'अभ्युक्ति',
              isMandatory: false, // Assuming remarks are not mandatory
              keyboardType: TextInputType.multiline,
              // minLines: 3, // Optional: for multiline text field
              // maxLines: 5, // Optional: for multiline text field
            ),
            const SizedBox(height: 20),
            Center(
              child: ElevatedButton.icon(
                onPressed: controller.takeLocation, 
                icon: const Icon(Icons.location_on),
                label: const Text('TAKE LOCATION'),
                style: ElevatedButton.styleFrom(
                  backgroundColor: theme.colorScheme.secondaryContainer, // Themed color
                  foregroundColor: theme.colorScheme.onSecondaryContainer, // Themed color
                  padding: const EdgeInsets.symmetric(horizontal: 30, vertical: 12),
                  textStyle: const TextStyle(fontSize: 15),
                ),
              ),
            ),
            
            const SizedBox(height: 24),
            Obx(() => Center(
                  child: controller.isLoading.value
                      ? const CircularProgressIndicator()
                      : ElevatedButton(
                          onPressed: controller.submitForm,
                          style: ElevatedButton.styleFrom(
                            backgroundColor: theme.colorScheme.primary, // Themed color
                            foregroundColor: theme.colorScheme.onPrimary, // Themed color
                            padding: const EdgeInsets.symmetric(horizontal: 50, vertical: 15),
                            textStyle: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                          ),
                          child: const Text('सेभ करें'), // Changed text to Hindi
                        ),
                )),
          ],
        ),
      ),
       bottomNavigationBar: Container(
        padding: const EdgeInsets.all(12.0),
        color: theme.colorScheme.surfaceVariant, // Themed color
        child: Text(
          'Services provided by: NIC Bihar',
          textAlign: TextAlign.center,
          style: TextStyle(fontSize: 12, color: theme.colorScheme.onSurfaceVariant), // Themed color
        ),
      ),
    );
  }
} 
