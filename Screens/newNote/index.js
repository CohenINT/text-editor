/* eslint-disable prettier/prettier */
import React from 'react';
import { StyleSheet, View } from 'react-native';
import Title from './title';
import Content from './content';
import ToastExample from './ToastExample';





export default function App() {





  ToastExample.show('Awesome', ToastExample.SHORT);
  return (
    <View>  
      <Title />
      <Content />

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
