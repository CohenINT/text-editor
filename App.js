/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {StyleSheet, Text, View} from 'react-native';
import NewNote from './Screens/newNote/index';
import MainPage from './Screens/mainPage/index';

export default function App() {
  return (
    <View>
      <MainPage></MainPage>
      



    </View>
  );
};

const styles = StyleSheet.create({
  title: {
    backgroundColor: 'red',
  },
});
