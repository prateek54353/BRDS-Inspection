import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:flutter/services.dart';
import '../controllers/inspection_form_controller.dart';

class _InfoRowWidget extends StatelessWidget {
  final String label;
  final String value;

  const _InfoRowWidget({required this.label, required this.value});

  @override
  Widget build(BuildContext context) {
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
}

class _InfoCardWidget extends StatelessWidget {
  final ReportListItemData data;

  const _InfoCardWidget({required this.data});

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    return Card(
      color: theme.colorScheme.primaryContainer.withAlpha((255 * 0.2).round()), // Themed background
      margin: const EdgeInsets.only(bottom: 20.0),
      elevation: 1, // Reduced elevation for a flatter look with themed background
      shape: const RoundedRectangleBorder(borderRadius: BorderRadius.all(Radius.circular(8.0))),
      child: Padding(
        padding: const EdgeInsets.all(12.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            _InfoRowWidget(label: 'Work Code', value: data.workCode),
            _InfoRowWidget(label: 'Work Name', value: data.workName),
            _InfoRowWidget(label: 'Work Type', value: data.workType),
            _InfoRowWidget(label: 'Agency Name', value: data.agencyName),
            _InfoRowWidget(label: 'Financial Year', value: data.financialYear),
          ],
        ),
      ),
    );
  }
}

class _DropdownFieldWidget extends StatelessWidget {
  final Rx<String?> selectedValueController;
  final String? labelText;
  final List<String> items;
  final String? hintText;
  final bool isMandatory;
  final String? Function(String?)? validator;

  const _DropdownFieldWidget({
    required this.selectedValueController,
    this.labelText,
    required this.items,
    this.hintText = '-चयन करें-',
    this.isMandatory = true,
    this.validator,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: Obx(() => DropdownButtonFormField<String>(
        decoration: InputDecoration(
          labelText: (labelText != null && labelText!.isNotEmpty) ? labelText! + (isMandatory ? ' *' : '') : null,
          border: const OutlineInputBorder(),
          contentPadding: const EdgeInsets.symmetric(horizontal: 10, vertical: 5),
        ),
        hint: (labelText == null || labelText!.isEmpty) ? Text(hintText!) : null,
        value: selectedValueController.value,
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
        validator: validator,
        autovalidateMode: validator != null ? AutovalidateMode.onUserInteraction : AutovalidateMode.disabled,
      )),
    );
  }
}

class _LocationCaptureWidget extends StatelessWidget {
  final InspectionFormController controller;

  const _LocationCaptureWidget({required this.controller});

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    return Column(
      children: [
        Center(
          child: ElevatedButton(
            onPressed: () {
              controller.takeLocation();
            },
            child: const Text('TAKE LOCATION'),
            style: ElevatedButton.styleFrom(
              backgroundColor: theme.colorScheme.secondaryContainer,
              foregroundColor: theme.colorScheme.onSecondaryContainer,
              padding: const EdgeInsets.symmetric(horizontal: 30, vertical: 12),
              textStyle: const TextStyle(fontSize: 15),
            ),
          ),
        ),
        Obx(() {
          if (controller.isLocationCaptured.value && controller.capturedLocationCoordinates.value.isNotEmpty) {
            return Padding(
              padding: const EdgeInsets.only(top: 8.0, bottom: 8.0),
              child: Text(
                'कैप्चर की गई लोकेशन: ${controller.capturedLocationCoordinates.value}',
                style: theme.textTheme.bodyMedium?.copyWith(color: theme.colorScheme.primary),
                textAlign: TextAlign.center,
              ),
            );
          }
          return const SizedBox.shrink();
        }),
      ],
    );
  }
}

class InspectionFormView extends GetView<InspectionFormController> {
  InspectionFormView({super.key});

  final _formKey = GlobalKey<FormState>(); // Add form key

// _buildInfoCard and _buildInfoRow methods were here, now extracted into widgets.






  Widget _buildTextField({
    required TextEditingController controller,
    required String labelText,
    TextInputType keyboardType = TextInputType.text,
    bool isMandatory = true,
    bool isReadOnly = false,
    String? Function(String?)? validator,
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
        validator: validator,
        autovalidateMode: validator != null ? AutovalidateMode.onUserInteraction : AutovalidateMode.disabled,
      ),
    );
  }



  Widget _buildHorizontalTextField({
    required BuildContext context, // Added context parameter
    required TextEditingController controller,
    required String labelText,
    String? hintText,
    TextInputType keyboardType = TextInputType.text,
    bool isMandatory = true,
    bool isReadOnly = false,
    List<TextInputFormatter>? inputFormatters,
    String? Function(String?)? validator,
  }) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          Text(
            '$labelText${isMandatory ? " *" : ""}',
            style: Theme.of(context).textTheme.bodyLarge, // Consistent styling for label
          ),
          const SizedBox(width: 10),
          Expanded(
            child: TextFormField(
              controller: controller,
              decoration: InputDecoration(
                hintText: hintText,
                border: OutlineInputBorder(),
                contentPadding: const EdgeInsets.symmetric(horizontal: 10, vertical: 12),
              ),
              keyboardType: keyboardType,
              readOnly: isReadOnly,
              inputFormatters: inputFormatters,
              validator: validator,
              autovalidateMode: validator != null ? AutovalidateMode.onUserInteraction : AutovalidateMode.disabled,
            ),
          ),
        ],
      ),
    );
  }

  // Helper method to show a dialog prompting the user to take location
  void _showPromptTakeLocationDialog(BuildContext context, InspectionFormController controller) {
    final theme = Theme.of(context);
    Get.dialog(
      AlertDialog(
        title: const Text('लोकेशन आवश्यक'), // Location Required
        content: const Text('कृपया फॉर्म सेव करने से पहले लोकेशन सुनिश्चित करें।'), // Please ensure location is taken before saving the form.
        actions: <Widget>[
          TextButton(
            child: Text('रद्द करें', style: TextStyle(color: theme.colorScheme.onSurfaceVariant)), // Cancel
            onPressed: () {
              Get.back(); // Close the dialog
            },
          ),
          ElevatedButton(
            style: ElevatedButton.styleFrom(
              backgroundColor: theme.colorScheme.primary,
              foregroundColor: theme.colorScheme.onPrimary,
            ),
            child: const Text('लोकेशन लें'), // Take Location
            onPressed: () {
              Get.back(); // Close this prompt dialog
              controller.takeLocation(); // Call the main location taking logic
            },
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    // Dummy items for dropdowns - replace with actual data sources
    final List<String> siteOptions = [
      'सड़क के किनारे',
      'जल संचयन संरचना के किनारे',
      'निजी भूमि',
      'अन्य सरकारी जमीन',
    ];
    // Removed paymentOptions as they are replaced by month/year
    final List<String> typeOptions = ['वृक्षारोपण', 'पौधरोपण']; // New: Type of Plantation options

    // Define month and year options
    final List<String> monthOptions = [
      'जनवरी', 'फरवरी', 'मार्च', 'अप्रैल', 'मई', 'जून',
      'जुलाई', 'अगस्त', 'सितंबर', 'अक्टूबर', 'नवंबर', 'दिसंबर'
    ];
    final List<String> yearOptions = 
        List<String>.generate(11, (i) => (2015 + i).toString()); // Years 2015-2025

    return Scaffold(
      appBar: AppBar(
        backgroundColor: theme.colorScheme.primaryContainer,
        foregroundColor: theme.colorScheme.onPrimaryContainer,
        elevation: 0, // Flat design consistent with other screens
        systemOverlayStyle: SystemUiOverlayStyle(
          statusBarColor: theme.colorScheme.primaryContainer, // Match AppBar background
          // Icons light on dark BG, dark on light BG
          statusBarIconBrightness: theme.brightness == Brightness.dark ? Brightness.light : Brightness.dark,
          // For iOS: Brightness.dark means light content, Brightness.light means dark content
          statusBarBrightness: theme.brightness == Brightness.dark ? Brightness.dark : Brightness.light,
        ),
        title: const Text('BRDS Inspection', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)), // foregroundColor will handle text color
        centerTitle: true,
        bottom: PreferredSize( // Adding a subtle bottom border for consistency
          preferredSize: const Size.fromHeight(1.0),
          child: Container(
            color: theme.colorScheme.outline.withAlpha((255 * 0.5).round()), // Subtle border color
            height: 1.0,
          ),
        ),
      ),
      body: Form(
        key: _formKey,
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              // Display received report data
              Obx(() {
                if (controller.reportData.value == null) {
                  return const Center(child: Text("No report data found."));
                }
                // Wrap _InfoCardWidget with RepaintBoundary
                return RepaintBoundary(
                  child: _InfoCardWidget(data: controller.reportData.value!)
                );
              }),

              Text('वृक्षारोपण उत्तरजीविता प्रतिवेदन', style: theme.textTheme.titleMedium?.copyWith(fontWeight: FontWeight.bold)),
              const SizedBox(height: 16),

              _DropdownFieldWidget(
                selectedValueController: controller.selectedSite,
                labelText: 'वृक्षारोपण का स्थल',
                items: siteOptions,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'कृपया वृक्षारोपण का स्थल चुनें';
                  }
                  return null;
                },
              ),
              _DropdownFieldWidget(
                selectedValueController: controller.selectedType,
                labelText: 'वृक्षारोपण का प्रकार',
                items: typeOptions,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'कृपया वृक्षारोपण का प्रकार चुनें';
                  }
                  return null;
                },
              ),
              _buildTextField(
                controller: controller.plantedSaplingsController,
                labelText: 'रोपित पौधों की संख्या',
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'कृपया रोपित पौधों की संख्या डालें';
                  }
                  if (int.tryParse(value) == null) {
                    return 'कृपया मान्य संख्या डालें';
                  }
                  return null;
                },
              ),
              _buildTextField(
                controller: controller.survivedSaplingsController,
                labelText: 'उत्तरजीवित पौधों की संख्या',
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'कृपया उत्तरजीवित पौधों की संख्या डालें';
                  }
                  if (int.tryParse(value) == null) {
                    return 'कृपया मान्य संख्या डालें';
                  }
                  return null;
                },
              ),
              _buildHorizontalTextField(
                context: context, // Pass context
                controller: controller.survivalPercentageController,
                labelText: 'उत्तरजीविता प्रतिशत',
                hintText: 'उत्तरजीविता प्रतिशत',
                keyboardType: TextInputType.numberWithOptions(decimal: true),
                isReadOnly: false, // Allow input
                isMandatory: true, // As per image '*' indicator
                inputFormatters: [FilteringTextInputFormatter.allow(RegExp(r'[0-9.]'))],
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'कृपया प्रतिशत डालें'; // Please enter percentage
                  }
                  final n = double.tryParse(value);
                  if (n == null) {
                    return 'कृपया मान्य संख्या डालें'; // enter a valid number
                  }
                  if (n < 0 || n > 100) {
                    return 'प्रतिशत 0 और 100 के बीच होना चाहिए'; // Percentage must be between 0 and 100
                  }
                  return null;
                },
              ),
              _buildHorizontalTextField(
                context: context, // Pass context
                controller: controller.vanposhakCountController,
                labelText: 'वनपोषक की संख्या',
                hintText: 'संख्या डालें', // For consistency with similar fields
                keyboardType: TextInputType.number,
                isMandatory: true, // As per image '*' indicator
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'कृपया वनपोषक की संख्या डालें';
                  }
                  if (int.tryParse(value) == null) {
                    return 'कृपया मान्य संख्या डालें';
                  }
                  return null;
                },
              ),
              _buildTextField(
                controller: controller.replacedSaplingsController,
                labelText: 'मृत पौधों के स्थान पर प्रतिस्थापित पौधों की संख्या',
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'कृपया प्रतिस्थापित पौधों की संख्या डालें';
                  }
                  if (int.tryParse(value) == null) {
                    return 'कृपया मान्य संख्या डालें';
                  }
                  return null;
                },
              ),
              const SizedBox(height: 16),
              Padding(
                padding: const EdgeInsets.only(bottom: 8.0, top: 8.0),
                child: Text(
                  'वनपोषक का अध्ययन भुगतान *',
                  style: Theme.of(context).textTheme.bodyLarge?.copyWith(color: Theme.of(context).colorScheme.onSurfaceVariant, fontWeight: FontWeight.normal, fontSize: Theme.of(context).textTheme.labelLarge?.fontSize),
                ),
              ),
              Row(
                children: [
                  Expanded(
                    child: _DropdownFieldWidget(
                      selectedValueController: controller.selectedMonth,
                      labelText: 'माह चुनें', // Select Month
                      items: monthOptions,
                      validator: (value) {
                        if (value == null || value.isEmpty) {
                          return 'कृपया माह चुनें';
                        }
                        return null;
                      },
                    ),
                  ),
                  const SizedBox(width: 8),
                  Expanded(
                    child: _DropdownFieldWidget(
                      selectedValueController: controller.selectedYear,
                      labelText: 'वर्ष चुनें', // Select Year
                      items: yearOptions,
                      validator: (value) {
                        if (value == null || value.isEmpty) {
                          return 'कृपया वर्ष चुनें';
                        }
                        return null;
                      },
                    ),
                  ),
                ],
              ),
              _buildTextField(
                controller: controller.averagePlantHeightController,
                labelText: 'पौधे की औसत ऊंचाई (फीट में)', // Added unit for clarity
                keyboardType: TextInputType.numberWithOptions(decimal: true),
                validator: (value) { // Assuming this is mandatory based on typical forms
                  if (value == null || value.isEmpty) {
                    return 'कृपया पौधे की औसत ऊंचाई डालें';
                  }
                  if (double.tryParse(value) == null) {
                    return 'कृपया मान्य ऊंचाई डालें';
                  }
                  return null;
                },
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
              _LocationCaptureWidget(controller: controller),
              const SizedBox(height: 20),
              Obx(() => Center(
                child: controller.isLoading.value
                    ? const CircularProgressIndicator()
                    : ElevatedButton(
                  onPressed: () {
                    if (_formKey.currentState!.validate()) {
                      if (controller.isLocationCaptured.value) {
                        controller.submitForm();
                      } else {
                        _showPromptTakeLocationDialog(context, controller);
                      }
                    }
                  },
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
      ),
      bottomNavigationBar: Container(
        padding: const EdgeInsets.only(bottom: 18.0),
        color: theme.colorScheme.surfaceContainerHighest, // Themed color
        child: Text(
          'Services provided by: NIC Bihar',
          textAlign: TextAlign.center,
          style: TextStyle(fontSize: 12, color: theme.colorScheme.onSurfaceVariant), // Themed color
        ),
      ),
    );
  }
}
