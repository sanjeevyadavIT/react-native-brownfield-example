import React from 'react';
import { View, Text } from 'react-native';
import { AppRegistry } from 'react-native';

const App = () => (
	<View style={{ flex: 1, backgroundColor: 'red' }}>
		<Text style={{ marginTop: 32, fontSize: 32, color: 'white' }}>RN 0.76</Text>
	</View>
);

AppRegistry.registerComponent('RootComponent', () => App);
