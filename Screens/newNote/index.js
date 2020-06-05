/* eslint-disable prettier/prettier */
import React from 'react';
import {StyleSheet, View} from 'react-native';
import Title from './title';

export default function App() {
  return (
    <View>
      <Title />
    </View>
  );
}

const styles = StyleSheet.create({
  title: {
    fontSize:91,
    backgroundColor: 'red',
    display: 'flex',
  },
});
