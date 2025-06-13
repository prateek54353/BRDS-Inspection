class ApiConfig {
  // Replace with your actual localhost IP address if running on a physical device.
  // 10.0.2.2 is the standard alias for the host machine's localhost from the Android emulator.
  static const String baseUrl = 'http://10.0.2.2:8080/api'; // Example: 'http://192.168.1.10:3000/api'

  // Specific Endpoints
  static const String login = '/auth/login';
  
  // You can add other endpoints here
  // static const String getProfile = '/user/profile';
} 