/* eslint-disable prettier/prettier */
import React from 'react';
import {Text, StyleSheet, View} from 'react-native';


export default function App() {
    return (
      <View>
        <Text style={styles.title}>Hello World!! </Text>
        
  
      </View>
    );
  };


  const styles = StyleSheet.create({
    title: {
      fontSize:33,
      backgroundColor: 'red',
      
        alignContent:'center',
  });
  