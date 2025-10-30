# Android Login App

A modern, feature-rich Android login application built with Kotlin and Material Design 3 components.

## Features

### 🎨 Modern UI Design
- Clean and intuitive Material Design 3 interface
- Smooth animations and transitions
- Responsive layout that adapts to different screen sizes
- Custom gradient backgrounds and styled components
- Professional color scheme with primary purple theme

### 🔐 Authentication Features
- **Email/Password Login**: Standard authentication with validation
- **Social Login Options**: Google and Facebook login integration ready
- **Remember Me**: Option to save login credentials
- **Forgot Password**: Password recovery functionality
- **Sign Up Navigation**: Easy access to registration

### ✅ Input Validation
- Real-time email format validation
- Password strength requirements (minimum 6 characters)
- Clear error messages with Material Design text input layouts
- Visual feedback for invalid inputs

### 🎯 User Experience
- Loading indicator during authentication
- Toast notifications for user feedback
- Smooth scrolling for smaller screens
- Keyboard-aware layout adjustments
- Clickable forgot password and sign-up links

## Technical Stack

### Languages & Frameworks
- **Kotlin**: Modern Android development language
- **Android SDK**: Target SDK 34, Min SDK 24
- **Material Design 3**: Latest Material Components

### Key Libraries
- **AndroidX Core KTX**: Kotlin extensions for Android
- **Material Components**: Material Design UI components
- **ConstraintLayout**: Flexible layout system
- **Lifecycle Components**: ViewModel and LiveData support
- **Coroutines**: Asynchronous programming
- **Retrofit**: HTTP client for API calls (ready for integration)
- **OkHttp**: Network logging and interceptors

### Architecture
- **MVVM Pattern Ready**: Structured for ViewModel integration
- **View Binding**: Type-safe view access
- **SharedPreferences**: Local data persistence

## Project Structure

```
android-login-app/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/loginapp/
│   │       │   └── LoginActivity.kt          # Main login activity
│   │       ├── res/
│   │       │   ├── drawable/                  # Vector drawables and backgrounds
│   │       │   │   ├── ic_login_logo.xml     # App logo
│   │       │   │   ├── ic_email.xml          # Email icon
│   │       │   │   ├── ic_lock.xml           # Password icon
│   │       │   │   ├── ic_google.xml         # Google icon
│   │       │   │   ├── ic_facebook.xml       # Facebook icon
│   │       │   │   ├── bg_button_gradient.xml # Button gradient
│   │       │   │   └── bg_social_button.xml  # Social button background
│   │       │   ├── layout/
│   │       │   │   └── activity_login.xml    # Login screen layout
│   │       │   ├── values/
│   │       │   │   ├── colors.xml            # Color definitions
│   │       │   │   ├── strings.xml           # String resources
│   │       │   │   └── themes.xml            # App themes
│   │       │   └── mipmap-*/                 # Launcher icons
│   │       └── AndroidManifest.xml           # App manifest
│   └── build.gradle                          # App-level build config
├── build.gradle                              # Project-level build config
├── gradle.properties                         # Gradle properties
└── settings.gradle                           # Gradle settings
```

## Setup Instructions

### Prerequisites
- Android Studio Arctic Fox or later
- JDK 8 or higher
- Android SDK with API level 34
- Gradle 8.2.0 or higher

### Installation Steps

1. **Clone or Download the Project**
   ```bash
   cd android-login-app
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the `android-login-app` directory
   - Click "OK"

3. **Sync Gradle**
   - Android Studio will automatically sync Gradle
   - Wait for the sync to complete
   - Resolve any dependency issues if prompted

4. **Build the Project**
   ```bash
   ./gradlew build
   ```

5. **Run on Device/Emulator**
   - Connect an Android device or start an emulator
   - Click the "Run" button in Android Studio
   - Select your target device

## Usage Guide

### Login Flow

1. **Enter Credentials**
   - Input a valid email address
   - Enter a password (minimum 6 characters)
   - Optionally check "Remember Me"

2. **Submit**
   - Click the "Login" button
   - A loading indicator will appear
   - Success/error message will be displayed

3. **Alternative Options**
   - Click "Forgot Password?" to recover account
   - Use Google or Facebook login buttons
   - Click "Sign Up" to create a new account

### Validation Rules

- **Email**: Must be a valid email format (e.g., user@example.com)
- **Password**: Minimum 6 characters required
- Empty fields will show error messages
- Invalid formats will display helpful hints

## Customization

### Colors
Edit `res/values/colors.xml` to change the color scheme:
```xml
<color name="primary">#6200EE</color>
<color name="primary_dark">#3700B3</color>
<color name="accent">#03DAC5</color>
```

### Strings
Modify `res/values/strings.xml` for text content:
```xml
<string name="app_name">Your App Name</string>
<string name="welcome_back">Your Welcome Message</string>
```

### Logo
Replace `res/drawable/ic_login_logo.xml` with your custom logo

### Theme
Adjust `res/values/themes.xml` for overall app styling

## API Integration

The app is ready for backend integration. To connect to your API:

1. **Update Retrofit Configuration**
   - Add your base URL in a Constants file
   - Create API interface with endpoints
   - Implement authentication service

2. **Modify LoginActivity**
   - Replace the simulated login in `performLogin()`
   - Add actual API calls using Retrofit
   - Handle responses and errors appropriately

3. **Example Integration**
   ```kotlin
   // In performLogin() method
   viewModelScope.launch {
       try {
           val response = authRepository.login(email, password)
           if (response.isSuccessful) {
               // Handle success
           } else {
               // Handle error
           }
       } catch (e: Exception) {
           // Handle exception
       }
   }
   ```

## Social Login Integration

### Google Sign-In
1. Add Google Play Services dependency
2. Configure OAuth 2.0 credentials in Google Cloud Console
3. Implement Google Sign-In flow in `handleGoogleLogin()`

### Facebook Login
1. Add Facebook SDK dependency
2. Register app on Facebook Developers
3. Implement Facebook Login flow in `handleFacebookLogin()`

## Testing

### Manual Testing
- Test with valid/invalid email formats
- Try different password lengths
- Verify "Remember Me" functionality
- Test forgot password flow
- Check social login buttons

### Unit Testing
- Add test cases for email validation
- Test password validation logic
- Mock API responses for login flow

## Security Considerations

- ✅ Passwords are masked during input
- ✅ HTTPS should be used for API calls
- ✅ Credentials stored securely in SharedPreferences
- ⚠️ Implement proper token management for production
- ⚠️ Add certificate pinning for enhanced security
- ⚠️ Use encrypted SharedPreferences for sensitive data

## Future Enhancements

- [ ] Biometric authentication (fingerprint/face)
- [ ] Two-factor authentication (2FA)
- [ ] Password strength indicator
- [ ] Dark mode support
- [ ] Multi-language support
- [ ] Offline mode handling
- [ ] Session management
- [ ] Account lockout after failed attempts

## Troubleshooting

### Common Issues

**Build Errors**
- Ensure all dependencies are properly synced
- Check Gradle version compatibility
- Clean and rebuild project

**Layout Issues**
- Verify all drawable resources exist
- Check XML syntax in layout files
- Ensure proper namespace declarations

**Runtime Crashes**
- Check AndroidManifest.xml configuration
- Verify all view IDs match between XML and Kotlin
- Review logcat for detailed error messages

## License

This project is open source and available for educational and commercial use.

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for bugs and feature requests.

## Contact

For questions or support, please open an issue in the project repository.

---

**Built with ❤️ using Kotlin and Material Design**
