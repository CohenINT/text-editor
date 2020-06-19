/* eslint-disable prettier/prettier */
import React,{useState} from 'react';
import {StyleSheet, View, TextInput} from 'react-native';


export default function App(props) {


    return (
      <View>
        <TextInput value={props.title} multiline={true} numberOfLines={1} style={styles.title}
        onChangeText={
          (e)=>props.setTitleValue(e)
        }
          
         />


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
