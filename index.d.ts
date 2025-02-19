declare class Sound {
    constructor(filename: string, basePath?: string, callback?: (error: any) => void);
  
    isLoaded(): boolean;
    play(onEnd?: (success: boolean) => void): void;
    pause(): void;
    stop(): void;
    reset(): void;
    release(): void;
  
    setPan(value: number): void;
    getPan(): number;
  
    getNumberOfChannels(): number;
    getDuration(): number;
  
    setCurrentTime(time: number): void;
    getCurrentTime(): number;
  
    setVolume(value: number): void;
    getVolume(): number;
  
    setNumberOfLoops(value: number): void;
    getNumberOfLoops(): number;
  
    setCategory(value: string): void;
  
    getSpeed(): number;
    setSpeed(value: number): void;
  
    getPitch(): number;
    setPitch(value: number): void;
  
    enableInSilenceMode(enabled: boolean): void;
    setSpeakerphoneOn(enabled: boolean): void;
    
    isPlaying(): boolean;
  
    static MAIN_BUNDLE: string;
  }
  
  export default Sound;