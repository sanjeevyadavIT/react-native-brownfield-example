import React from "react";

const SyncStatus = {
  CHECKING_FOR_UPDATE: "CHECKING_FOR_UPDATE",
  DOWNLOADING_PACKAGE: "DOWNLOADING_PACKAGE",
  INSTALLING_UPDATE: "INSTALLING_UPDATE",
  UP_TO_DATE: "UP_TO_DATE",
  UPDATE_INSTALLED: "UPDATE_INSTALLED",
  UNKNOWN_ERROR: "UNKNOWN_ERROR",
};

const CodePush = (config) => (AppComponent) => {
  return function WrappedComponent(props) {
    return <AppComponent {...props} />;
  };
};

CodePush.sync = () => {
  console.log("CodePush.sync() called");
};

CodePush.checkForUpdate = () => {
  console.log("CodePush.checkForUpdate() called");
  return Promise.resolve(null);
};

CodePush.installUpdate = () => {
  console.log("CodePush.installUpdate() called");
};

CodePush.getUpdateMetadata = async (updateState) => {
  console.log(`CodePush.getUpdateMetadata(${updateState}) called`);
  return Promise.resolve(null);
};

CodePush.SyncStatus = SyncStatus;
CodePush.CheckFrequency = {};
CodePush.InstallMode = {};
CodePush.UpdateState = {};

export default CodePush;
export const { sync, checkForUpdate, installUpdate } = CodePush;