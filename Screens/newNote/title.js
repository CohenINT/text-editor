/* eslint-disable prettier/prettier */
import React,{useState} from 'react';
import {Text, StyleSheet, View, TextInput} from 'react-native';


export default function App() {
  const [title,setTitle] = useState('');


    return (
      <View>
        <TextInput multiline={true} numberOfLines={1} style={styles.title}
        onChangeText={
          (e)=>setTitle(e)
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
