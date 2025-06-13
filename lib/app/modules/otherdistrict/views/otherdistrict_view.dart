import 'package:flutter/material.dart';

import 'package:get/get.dart';

import '../controllers/otherdistrict_controller.dart';

class OtherdistrictView extends GetView<OtherdistrictController> {
  const OtherdistrictView({super.key});
  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);

    // Hardcoded list of districts for now
    final List<Map<String, String>> districts = [
      {'name': 'अपने क्षेत्र में', 'zilla': '', 'prakhand': '', 'panchayat': ''},
      {'name': 'BEGUSARAI', 'zilla': 'BEGUSARAI', 'prakhand': 'BEGUSARAI', 'panchayat': 'RAJAURA'},
      // Add more mock districts here as needed
    ];

    return Scaffold(
      appBar: AppBar(
        backgroundColor: theme.colorScheme.primaryContainer,
        foregroundColor: theme.colorScheme.onPrimaryContainer,
        elevation: 0,
        leading: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Image.asset('assets/brds.jpg', height: 40), // Using bid_logo as per image
        ),
        title: Obx(() => Text(controller.selectedDistrictName.value, style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold))), // Dynamic title
        centerTitle: true,
        actions: <Widget>[
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Image.asset('assets/govbihar.png', height: 40), // Using govbihar as per image
          ),
        ],
        bottom: PreferredSize(
          preferredSize: const Size.fromHeight(1.0),
          child: Container(
            color: theme.colorScheme.outline.withAlpha((255 * 0.5).round()),
            height: 1.0,
          ),
        ),
      ),
      body: Column(
        children: [

          Expanded(
            child: ListView.builder(
              itemCount: districts.length,
              itemBuilder: (context, index) {
                final district = districts[index];
                return GestureDetector(
                  onTap: () {
                    controller.selectDistrict(district); // Pass the entire district map
                  },
                  child: Card(
                    margin: const EdgeInsets.symmetric(horizontal: 8.0, vertical: 4.0),
                    elevation: 1,
                    child: Padding(
                      padding: const EdgeInsets.all(12.0),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            '${index + 1}) ${district['name']}',
                            style: theme.textTheme.titleMedium?.copyWith(fontWeight: FontWeight.bold),
                          ),
                          if (district['zilla']!.isNotEmpty) ...[
                            const SizedBox(height: 8),
                            Row(
                              children: [
                                Expanded(child: Text('जिला', style: theme.textTheme.bodySmall?.copyWith(fontWeight: FontWeight.bold))),
                                Expanded(child: Text('प्रखंड', style: theme.textTheme.bodySmall?.copyWith(fontWeight: FontWeight.bold))),
                                Expanded(child: Text('पंचायत', style: theme.textTheme.bodySmall?.copyWith(fontWeight: FontWeight.bold))),
                              ],
                            ),
                            Row(
                              children: [
                                Expanded(child: Text(district['zilla']!, style: theme.textTheme.bodySmall)),
                                Expanded(child: Text(district['prakhand']!, style: theme.textTheme.bodySmall)),
                                Expanded(child: Text(district['panchayat']!, style: theme.textTheme.bodySmall)),
                              ],
                            ),
                          ],
                        ],
                      ),
                    ),
                  ),
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}