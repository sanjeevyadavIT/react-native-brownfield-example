import React, { Component } from 'react';
import { View } from 'react-native';

class VideoPlayer extends Component {
  constructor(props) {
    super(props);
    this.player = {
      ref: null, // Simulating the react-native-video ref
    };
  }

  seekTo(time) {
    // Do nothing
  }

  render() {
    return <View style={{ width: '100%', height: '100%', backgroundColor: 'black' }} />;
  }
}

export default VideoPlayer;