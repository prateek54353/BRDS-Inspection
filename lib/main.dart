import 'package:flutter/material.dart';
// import 'package:flutter/services.dart'; // No longer needed here
import 'package:get/get.dart';
import 'app/routes/app_pages.dart';
import 'app/services/auth_service.dart'; // Import AuthService
import 'package:permission_handler/permission_handler.dart';
// import 'package:myapp1/animated_splash_view.dart'; // Remove this import
import 'app/initializer/initial_binding.dart';

Future<void> main() async { // Make main async
  WidgetsFlutterBinding.ensureInitialized();
  await initServices(); // Initialize services before running the app
  // SystemChrome.setSystemUIOverlayStyle(SystemUiOverlayStyle.dark.copyWith(
  //   statusBarColor: Colors.transparent,      
  //   statusBarIconBrightness: Brightness.dark, 
  //   statusBarBrightness: Brightness.light,    
  // )); // This global setting is removed as AppHeader now handles it.
  runApp(const MyApp());
}

// Function to request location permission
Future<void> _requestLocationPermission() async {
  var status = await Permission.locationWhenInUse.status;
  if (status.isDenied) {
    // We haven't asked for permission yet or the permission has been denied before but not permanently.
    status = await Permission.locationWhenInUse.request();
    if (status.isGranted) {
      print("Location permission granted.");
    } else if (status.isDenied) {
      print("Location permission denied by user.");
      // Optionally, show a dialog explaining why the app needs this permission
    } else if (status.isPermanentlyDenied) {
      print("Location permission permanently denied. Please enable it in app settings.");
      // Optionally, guide user to app settings
      // await openAppSettings(); 
    }
  } else if (status.isGranted) {
    print("Location permission already granted.");
  } else if (status.isPermanentlyDenied || status.isRestricted) {
    print("Location permission is permanently denied or restricted. Please enable it in app settings.");
    // Optionally, guide user to app settings
    // await openAppSettings();
  }
}

// Function to initialize services
Future<void> initServices() async {
  print("Initializing services...");
  
  // Initialize AuthService
  final authService = await Get.putAsync(() => AuthService().init(), permanent: true);
  print("AuthService initialized: ${authService.hashCode}");
  
  // Request location permission
  await _requestLocationPermission();
  
  print("Services initialized!");
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    // Define a base dark color scheme for Material 3 style
    const darkColorScheme = ColorScheme(
      brightness: Brightness.dark,
      primary: Color(0xFF81C784), // Material Green 300
      onPrimary: Colors.black,
      primaryContainer: Color(0xFF388E3C), // Material Green 700
      onPrimaryContainer: Colors.white,
      secondary: Color(0xFF03DAC6), // Example: Teal - Can be adjusted if needed
      onSecondary: Colors.black,
      secondaryContainer: Color(0xFF2E7D32), // Material Green 800 for dark theme dashboard buttons
      onSecondaryContainer: Color(0xFFC8E6C9), // Material Green 100 for icon/text on dark green
      tertiary: Color(0xFF3700B3),
      onTertiary: Colors.white,
      tertiaryContainer: Color(0xFF4F378B),
      onTertiaryContainer: Colors.white, 
      error: Color(0xFFCF6679), // Standard M3 error color
      onError: Colors.black,
      surface: Color(0xFF1E1E1E), // Slightly lighter than background for surfaces like cards
      onSurface: Colors.white,
      surfaceContainerLowest: Color(0xFF121212), // Replaces background
      surfaceContainer: Color(0xFF2C2C2C), // Replaces surfaceVariant
      outline: Colors.grey,
      shadow: Colors.black,
      inverseSurface: Color(0xFFE0E0E0),
      onInverseSurface: Colors.black,
      inversePrimary: Color(0xFF4CAF50), // Material Green 500
    );

    return GetMaterialApp(
      title: 'Login App',
      debugShowCheckedModeBanner: false,
      themeMode: ThemeMode.system, // This respects system theme settings
      theme: ThemeData.light(useMaterial3: true).copyWith(
        // Custom light theme properties if needed
        // e.g., cardColor: Colors.white,
        // textTheme: ThemeData.light().textTheme.apply(bodyColor: Colors.black, displayColor: Colors.black)
        colorScheme: ThemeData.light(useMaterial3: true).colorScheme.copyWith(
              primary: Color(0xFF4CAF50), // Material Green 500
              onPrimary: Colors.white,
              primaryContainer: Color(0xFFC8E6C9), // Material Green 100
              onPrimaryContainer: Color(0xFF388E3C), // Material Green 700
              secondaryContainer: Color(0xFFC8E6C9), // Material Green 100 for light theme dashboard buttons
              onSecondaryContainer: Color(0xFF1B5E20), // Material Green 900 for icon/text on light green
              // secondary: Colors.blue, // Keep or define your secondary color
            ),
      ),
      darkTheme: ThemeData.from(colorScheme: darkColorScheme, useMaterial3: true).copyWith(
        // Custom dark theme properties if needed
        // e.g., cardColor: Colors.grey[850],
        // textTheme: ThemeData.dark().textTheme.apply(bodyColor: Colors.white, displayColor: Colors.white)
        // Further specific overrides for dark theme if ThemeData.from isn't enough
        // cardColor: darkColorScheme.surface, // Explicitly set if needed, but ThemeData.from should handle
        // scaffoldBackgroundColor: darkColorScheme.background, 
      ),
      initialRoute: AppPages.INITIAL,
      getPages: AppPages.routes,
      initialBinding: InitialBinding(),
    );
  }
}
