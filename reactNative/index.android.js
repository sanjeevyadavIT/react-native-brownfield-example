import React from "react";
import CodePush from "react-native-code-push";
import { View, Text, Button } from "react-native";
import { AppRegistry } from "react-native";

import NativeLocalStorage from "./specs/NativeLocalStorage";

const App = () => (
  <View style={{ flex: 1, backgroundColor: "red", marginTop: 100 }}>
    <Text style={{ marginTop: 32, fontSize: 32, color: "white" }}>RN 0.76, Default bundle</Text>
    <Button
      title="Call Native Module"
      onPress={() => NativeLocalStorage?.setItem("MyKEY", "MyValue")}
    />
  </View>
);

AppRegistry.registerComponent("RootComponent", () => CodePush(App));
