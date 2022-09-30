import SwiftUI
import MultiPlatformLibrary
import mokoMvvmFlowSwiftUI
import Combine

struct ContentView: View {
    
    @ObservedObject var viewModel: MainViewModel = MainViewModel()
//     let greet: String = MainViewModel().greetingBasicTest()

    init() {
        viewModel.initialize()
    }

	var body: some View {
		Text(viewModel.state(\.data))
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
