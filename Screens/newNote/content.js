/* eslint-disable prettier/prettier */
import React from 'react';
import {StyleSheet,TextInput ,Text,View} from 'react-native';

export default function App() {
  return (
    <View>

    <TextInput multiline={true}>
   hoio this tis text
    </TextInput>

    </View>
  );
}

const styles = StyleSheet.create({
  title: {
    fontSize: 91,
    backgroundColor: 'red',
    display: 'flex',
  },
});
