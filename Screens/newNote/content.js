/* eslint-disable prettier/prettier */
import React,{useState} from 'react';
import {StyleSheet,TextInput  ,View} from 'react-native';

export default function App(props) {

 


  return (
    <View>

    <TextInput value={props.text}  multiline={true}
      onChangeText={
        (e)=>props.setContentValue(e)
      }
          
     />

  
    </View>
  );
}

// const styles = StyleSheet.create({
//   title: {
//     fontSize: 91,
//     backgroundColor: 'red',
//     display: 'flex',
//   },
// });
