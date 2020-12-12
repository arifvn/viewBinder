### viewBinder [![](https://jitpack.io/v/potatocandie/viewBinder.svg)](https://jitpack.io/#potatocandie/viewBinder)
Library to make ViewBinding easier to implement.

This is just simpler version of these awesome articles.💙
- [Article by Kirill Rozov](https://proandroiddev.com/make-android-view-binding-great-with-kotlin-b71dd9c87719)
- [Article by Seanghay](https://proandroiddev.com/viewbinding-with-kotlin-property-delegate-c907682e24c9)

They have created more robust lib. You can check that out.

#### How to implement
1. Add it in your root build.gradle at the end of repositories
```
  allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
  }
```
2. Enable viewBinding in your `build.gradle` file
```
  android {
      ...
      ...

      buildFeatures {
          viewBinding true
      }

      defaultConfig {
        ...
      }
  }
```
3. Add these dependencies
```
implementation 'com.github.potatocandie:viewBinder:0.1.0'
```
4. Using in Activity
```kotlin
  class MainActivity : AppCompatActivity() {
      // initialize binding
      private val binding: ActivityMainBinding by viewBinder()

      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)

          // use it as usual
          binding.btnCheckout.setOnClickListener {

          }
      }
  }
 ```
5. Using in Activity as NavController 
You can use built-in kotlin lazy function instead.
```kotlin
  // pass layout as argument
  class MainActivity : AppCompatActivity(R.layout.activity_main) {
      // initialize viewbinding
      private val binding: ActivityMainBinding by lazy {
          ActivityMainBinding.bind(findViewById<ViewGroup>(android.R.id.content)[0])
      }

      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)

          val navController = findNavController(R.id.nav_host_fragment)
          
          // it would throw an error if you use viewBinder, that's why I recommend you to use built-in lazy function instead.
          binding.bottomNav.setupWithNavController(navController)
      }
  }
 ```

6. Using in Fragment
```kotlin
  // pass layout id in the constructor
  class ProfileFragment : Fragment(R.layout.fragment_profile) {
  
      // initialize binding
      private val binding: FragmentProfileBinding by viewBinder()
     
      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
          
          // use it as usual
          binding.tvUsername.text = "John Doe"
      }
  }
```
