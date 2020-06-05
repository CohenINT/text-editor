/* eslint-disable prettier/prettier */
import React from 'react';
import {StyleSheet, View} from 'react-native';
import Title from './title';
import Content from './content';

export default function App() {
  return (
    <View>
      <Title />
      <Content/>
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
