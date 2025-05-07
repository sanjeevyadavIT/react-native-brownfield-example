import React from 'react';
import { View, Text } from 'react-native';
import { AppRegistry } from 'react-native';
import codePush from "react-native-code-push";

const App = () => (
	<View style={{ flex: 1, backgroundColor: 'red' }}>
		<Text style={{ marginTop: 32, fontSize: 32, color: 'white' }}>RN 0.76</Text>
	</View>
);

const MyApp = codePush(App);

AppRegistry.registerComponent('RootComponent', () => MyApp);
