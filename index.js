class Sound {
  constructor(filename, basePath, callback) {
    // Simulate async loading with a timeout
    setTimeout(() => {
      callback(null); // No error
    }, 100);
  }

  isLoaded(){return false}

  play(onEnd) {
    // Simulate playing sound
    if (onEnd) {
      setTimeout(() => {
        onEnd(false); // No error
      }, 1000); // Simulate 1 second playback
    }
  }

  pause(){}

  stop() {
    // Simulate stopping sound
  }

  reset(){}

  release() {
    // Simulate releasing sound resources
  }

  setPan(){}

  getPan(){}

  getNumberOfChannels(){}

  getDuration(){return 0}

  setCurrentTime(){}

  getCurrentTime(){}

  setVolume(){}

  getVolume(){}

  getNumberOfLoops(){}

  setNumberOfLoops(){}

  setCategory(){}

  getSpeed(){}

  setSpeed(){}

  getPitch(){}

  setPitch(){}

  enableInSilenceMode(){}

  setSpeakerphoneOn(){}

  isPlaying(){return false}
}

Sound.MAIN_BUNDLE = 'main_bundle';

export default Sound;