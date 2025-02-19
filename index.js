import { Image } from "react-native";

const FastImage = Image;

FastImage.resizeMode = {
    contain: 'contain',
    cover: 'cover', // Default
    stretch: 'stretch',
    center: 'center',
  };
  

export default FastImage;