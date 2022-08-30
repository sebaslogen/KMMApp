import SwiftUI
import shared
// import MultiPlatformLibrary
// import mokoMvvmFlowSwiftUI
import Combine

struct ContentView: View {
    
//     @ObservedObject var viewModel: MainViewModel = MainViewModel()
    let greet: String = MainViewModel().greetingBasicTest()

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
