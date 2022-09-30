import SwiftUI
import MultiPlatformLibrary
import mokoMvvmFlowSwiftUI
import Combine

struct ContentView: View {
    
    @ObservedObject var viewModel: MainViewModel = MainViewModel()

    init() {
        viewModel.initialize()
    }

	var body: some View {
	    VStack {
            Text(viewModel.state(\.data)).frame(maxHeight: 200)
            Button("Change my color") {
                viewModel.onChangeButtonPressed()
            }
            let a = MyColor.red.hexColor
            let color = viewModel.state(\.color)
//              There is a problem with flows of enums
//              Apparently for non-primitive types I need to do some extra wrapping/unwrapping https://medium.com/icerock/how-to-implement-swift-friendly-api-with-kotlin-multiplatform-mobile-e68521a63b6d
//              Check https://github.com/icerockdev/moko-mvvm/blob/7a1c28912a/sample-declarative-ui/shared/src/commonMain/kotlin/dev/icerock/moko/mvvm/sample/declarativeui/BookListViewModel.kt
//              and https://github.com/icerockdev/moko-mvvm/blob/7a1c28912a/sample-declarative-ui/iosApp/iosApp/BookListViewBinding.swift
//              For now, just use a String
//             let color = MPLMyColor(viewModel.state(\.color))
//             let colorString: String = String(MyColor(viewModel.state(\.color)).hexColor)
            Rectangle()
//                 .fill(Color.purple)
                .fill(Color(hexString: color) ?? Color.purple)
//                 .fill(Color(hexString: viewModel.state(\.color).hexValue) ?? Color.purple)
                .frame(width: 200, height: 200)
        }

	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
