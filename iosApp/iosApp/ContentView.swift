import SwiftUI
import shared

struct ContentView: View {
    let vmGreeter: String = MainViewModel().greeting()
 	let greeter: String = Greeter().greeting()
    let greet: String
    
    init() {
        self.greet = "\(greeter) \(vmGreeter)"
    }

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
