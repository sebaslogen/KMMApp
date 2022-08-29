import SwiftUI
import shared

struct ContentView: View {
    let greet = MainViewModel().greeting()
// 	let greeter = Greeter().greeting()
// 	let greet = "\(greeter) \(vm)"

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}