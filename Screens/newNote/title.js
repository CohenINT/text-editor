/* eslint-disable prettier/prettier */
import React from 'react';
import {Text, StyleSheet, View, TextInput} from 'react-native';


export default function App() {
    return (
      <View>
        <TextInput multiline={true} numberOfLines={1} style={styles.title}>Hello World!! </TextInput>


      </View>
    );
  }


  const styles = StyleSheet.create({
    title: {
      fontSize:33,
      flexDirection:'row',
      backgroundColor: 'red',

        alignContent:'center',
  },
});
