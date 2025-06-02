import 'package:flutter/material.dart';
import 'package:get/get.dart';
import '../../../routes/app_pages.dart'; // For navigation
import '../controllers/dashboard_controller.dart';

class DashboardView extends GetView<DashboardController> {
  const DashboardView({super.key});
  @override
  Widget build(BuildContext context) {
    final ThemeData theme = Theme.of(context);
    // final Color onPrimaryColor = theme.colorScheme.onPrimary; // Removed
    final Color primaryContainerColor = theme.colorScheme.primaryContainer;
    final Color onPrimaryContainerColor = theme.colorScheme.onPrimaryContainer;

    return Scaffold(
      // backgroundColor: theme.colorScheme.background, // The shell (HomeView) handles the overall background
      body: SafeArea(
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(8.0),
          child: Column(
            children: [
              // User/location info Card
              Obx(() {
                final userDetails = controller.loggedInUser.value?.userDetails;
                if (userDetails == null) {
                  return const Center(child: CircularProgressIndicator());
                }
                return Card(
                  // Card color is handled by theme.cardColor automatically
                  margin: const EdgeInsets.symmetric(horizontal: 4, vertical: 8),
                  elevation: 2,
                  child: Padding(
                    padding: const EdgeInsets.all(10.0),
                    child: Row(
                      children: [
                        Expanded(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(userDetails.name ?? 'N/A', style: theme.textTheme.titleMedium?.copyWith(fontWeight: FontWeight.bold)),
                              const SizedBox(height: 2),
                              Text('जिला: ${userDetails.distName ?? 'N/A'}', style: theme.textTheme.bodySmall),
                              Text('पंचायत: ${userDetails.panchayatName ?? 'N/A'}', style: theme.textTheme.bodySmall),
                            ],
                          ),
                        ),
                        Expanded(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text('विभाग: ${userDetails.department ?? 'N/A'}', style: theme.textTheme.bodySmall),
                              Text('प्रखण्ड: ${userDetails.blockName ?? 'N/A'}', style: theme.textTheme.bodySmall),
                            ],
                          ),
                        ),
                      ],
                    ),
                  ),
                );
              }),

             Padding(
                padding: const EdgeInsets.symmetric(horizontal: 4, vertical: 8),
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(10),
                  child: Image.asset('assets/plant.jpg', height: 120, width: double.infinity, fit: BoxFit.cover),
                ),
              ),
              const SizedBox(height: 8),
              
              // Green button - "सर्वर से डेटा लोड करें"
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 8.0, vertical: 8),
                child: ElevatedButton.icon(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: primaryContainerColor, // Theme-aware color
                    minimumSize: const Size.fromHeight(40),
                    shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
                  ),
                  icon: Icon(Icons.cloud_download, color: onPrimaryContainerColor), // Theme-aware icon color
                  label: Text('सर्वर से डेटा लोड करें', style: TextStyle(fontSize: 16, color: onPrimaryContainerColor)), // Theme-aware text color
                  onPressed: controller.reloadDataFromServer, // Connect to controller method
                ),
              ),
              const SizedBox(height: 10),

              // Main actions Card
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 0.0, vertical: 8),
                child: Card(
                  // Card color is handled by theme.cardColor automatically
                  elevation: 2,
                  shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
                  child: Padding(
                    padding: const EdgeInsets.all(12.0),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [
                        _DashboardActionButton(
                          icon: Icons.assignment, 
                          label: 'प्रतिवेदन करें', 
                          onTap: () => Get.toNamed(Routes.REPORT),
                        ),
                        _DashboardActionButton(icon: Icons.cloud_upload, label: 'अपलोड करें', onTap: () => Get.toNamed(Routes.UPLOAD)),
                        _DashboardActionButton(icon: Icons.assignment_turned_in, label: 'रिपोर्ट देखें', onTap: () => Get.toNamed(Routes.VIEW_REPORT)),
                      ],
                    ),
                  ),
                ),
              ),
              const SizedBox(height: 8),

              // Change Password button
              Padding(
                padding: const EdgeInsets.only(right: 8.0, bottom: 8.0),
                child: Align(
                  alignment: Alignment.centerRight,
                  child: OutlinedButton(
                    style: OutlinedButton.styleFrom(
                      foregroundColor: theme.colorScheme.primary, // Theme-aware text/icon color
                      side: BorderSide(color: theme.colorScheme.primary), // Theme-aware border color
                    ),
                    onPressed: () => Get.toNamed(Routes.CHANGE_PASSWORD),
                    child: const Text('Change Password'),
                  ),
                ),
              ),
              const SizedBox(height: 16), // Add some space before the logout button

              // Logout Button
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 8.0, vertical: 8.0),
                child: OutlinedButton.icon(
                  style: OutlinedButton.styleFrom(
                    foregroundColor: theme.colorScheme.error,
                    side: BorderSide(color: theme.colorScheme.error),
                    minimumSize: const Size.fromHeight(40), // Make it full width like other main buttons
                    shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
                  ),
                  icon: const Icon(Icons.logout),
                  label: const Text('Logout', style: TextStyle(fontSize: 16)),
                  onPressed: () {
                    // Call controller.logoutUser() - to be implemented
                    controller.logoutUser();
                  },
                ),
              ),
              const SizedBox(height: 8), // Space at the bottom
            ],
          ),
        ),
      ),
    );
  }
}

// _DashboardActionButton needs to be theme-aware too
class _DashboardActionButton extends StatelessWidget {
  final IconData icon;
  final String label;
  final VoidCallback? onTap;

  const _DashboardActionButton({
    required this.icon,
    required this.label,
    this.onTap,
  });

  @override
  Widget build(BuildContext context) {
    final ThemeData theme = Theme.of(context);
    final Color circleAvatarBg = theme.colorScheme.secondaryContainer;
    final Color iconColor = theme.colorScheme.onSecondaryContainer;

    // The content that will be animated or tapped
    Widget buttonContent = Column(
      mainAxisSize: MainAxisSize.min, 
      children: [
        CircleAvatar(
          radius: 28,
          backgroundColor: circleAvatarBg, 
          child: Icon(icon, size: 32, color: iconColor),
        ),
        const SizedBox(height: 7),
        Text(label, style: theme.textTheme.labelLarge?.copyWith(fontWeight: FontWeight.w500)),
      ],
    );

    return GestureDetector(
      onTap: onTap,
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: buttonContent,
      ),
    );
  }
}
