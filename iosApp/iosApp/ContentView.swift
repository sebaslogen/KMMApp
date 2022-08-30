import SwiftUI
import MultiPlatformLibrary
import mokoMvvmFlowSwiftUI
import Combine

struct ContentView: View {
    
    @ObservedObject var viewModel: MainViewModel = MainViewModel()
    
	var body: some View {
		Text("Hola test")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
