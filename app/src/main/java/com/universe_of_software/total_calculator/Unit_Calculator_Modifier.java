package com.universe_of_software.total_calculator;

import java.util.ArrayList;

public class Unit_Calculator_Modifier {


        ArrayList<UnitListSetter> LengthList = null;
        ArrayList<UnitListSetter> WeightList = null;
        ArrayList<UnitListSetter> AreaList = null;
        ArrayList<UnitListSetter> VolumeList = null;
        ArrayList<UnitListSetter> PressureList = null;
        ArrayList<UnitListSetter> TemperatureList = null;
        ArrayList<UnitListSetter> MileageList = null;
        ArrayList<UnitListSetter> SpeedList = null;
        ArrayList<UnitListSetter> DataList = null;

        Unit_Calculator_Modifier(){




            LengthList = new ArrayList<>();
            LengthList.add(new UnitListSetter("밀리미터(mm)",1000000));
            LengthList.add(new UnitListSetter("센티미터(cm)",100000));
            LengthList.add(new UnitListSetter("미터(m)",1000));
            LengthList.add(new UnitListSetter("킬로미터(km)",1));
            LengthList.add(new UnitListSetter("인치(in)",39370.0789));
            LengthList.add(new UnitListSetter("피트(ft)",3280.84));
            LengthList.add(new UnitListSetter("야드(yd)",1093.613));
            LengthList.add(new UnitListSetter("마일(mile)",0.6213711922373339));
            LengthList.add(new UnitListSetter("자(尺)",3300));
            LengthList.add(new UnitListSetter("간(間)",550));
            LengthList.add(new UnitListSetter("정(町)",9.17));
            LengthList.add(new UnitListSetter("리(理)",2.546));

            AreaList = new ArrayList<>();
            AreaList.add(new UnitListSetter("제곱미터(m²)",1000000));
            AreaList.add(new UnitListSetter("아르(a)",10000));
            AreaList.add(new UnitListSetter("헥타르(ha)",100));
            AreaList.add(new UnitListSetter("제곱킬로미터(km²)",1));
            AreaList.add(new UnitListSetter("제곱피트(ft²)",10763910));
            AreaList.add(new UnitListSetter("제곱야드(yd²)",1195990));
            AreaList.add(new UnitListSetter("에이커(ac)",247));
            AreaList.add(new UnitListSetter("평방자",10890000));
            AreaList.add(new UnitListSetter("평",302500));
            AreaList.add(new UnitListSetter("단보",1008));

            AreaList.add(new UnitListSetter("정보",101));

            WeightList = new ArrayList<>();

            WeightList.add(new UnitListSetter("밀리그램(mg)",1000000));
            WeightList.add(new UnitListSetter("그램(g)",1000));
            WeightList.add(new UnitListSetter("킬로그램(kg)",1));
            WeightList.add(new UnitListSetter("톤(t)",0.001));
            WeightList.add(new UnitListSetter("킬로톤(kt)",0.000001));
            WeightList.add(new UnitListSetter("그레인(gr)",15432));
            WeightList.add(new UnitListSetter("온스(oz)",35.273));
            WeightList.add(new UnitListSetter("파운드(lb)",2.20459));
            WeightList.add(new UnitListSetter("돈",266.666));
            WeightList.add(new UnitListSetter("냥",26.6666));
            WeightList.add(new UnitListSetter("근",1.6666));
            WeightList.add(new UnitListSetter("관",0.26666));

            VolumeList = new ArrayList<>();
            VolumeList.add(new UnitListSetter("시시(cc)",1000));
            VolumeList.add(new UnitListSetter("밀리리터(㎖)",1000));
            VolumeList.add(new UnitListSetter("데시리터(㎗)",10));
            VolumeList.add(new UnitListSetter("리터(ℓ)",1));
            VolumeList.add(new UnitListSetter("세제곱센티미터(cm³)",1000));
            VolumeList.add(new UnitListSetter("세제곱미터(m³)",0.001));
            VolumeList.add(new UnitListSetter("세제곱인치(in³)",61.027));
            VolumeList.add(new UnitListSetter("세제곱피트(ft³)",0.03531));
            VolumeList.add(new UnitListSetter("세제곱야드(yd³)",0.00130));
            VolumeList.add(new UnitListSetter("갤런(gal)",0.26418));
            VolumeList.add(new UnitListSetter("배럴(bbl)",0.00629326));
            VolumeList.add(new UnitListSetter("온스(oz)",33.814022));


            TemperatureList = new ArrayList<>();
            TemperatureList.add(new UnitListSetter("섭씨온도(℃)",1));
            TemperatureList.add(new UnitListSetter("화씨온도(℉)",33.8));
            TemperatureList.add(new UnitListSetter("절대온도(K)",274.15));
            TemperatureList.add(new UnitListSetter("(°R)",493.47));

            PressureList = new ArrayList<>();
            PressureList.add(new UnitListSetter("기압(atm)",1));
            PressureList.add(new UnitListSetter("파스칼(Pa)",101325));
            PressureList.add(new UnitListSetter("헥토파스칼(hPa)",1013.25));
            PressureList.add(new UnitListSetter("킬로파스칼(kPa)",101.325));
            PressureList.add(new UnitListSetter("메가파스칼(MPa)",0.101325));
            PressureList.add(new UnitListSetter("dcyn/cm²",1013250));
            PressureList.add(new UnitListSetter("밀리바(mb)",1013.25));
            PressureList.add(new UnitListSetter("바(bar)",1.01325));
            PressureList.add(new UnitListSetter("kgf(cm²)",1.033227));
            PressureList.add(new UnitListSetter("프사이(psi)",14.696));
            PressureList.add(new UnitListSetter("수은주밀리미터(mmHg)",760));
            PressureList.add(new UnitListSetter("inchHg",29.92126));

            SpeedList = new ArrayList<>();
            SpeedList.add(new UnitListSetter("m/s",1));
            SpeedList.add(new UnitListSetter("m/h",3600));
            SpeedList.add(new UnitListSetter("km/s",0.001));
            SpeedList.add(new UnitListSetter("km/h",3.6));
            SpeedList.add(new UnitListSetter("in/s",39.370079));
            SpeedList.add(new UnitListSetter("in/h",141732.283));
            SpeedList.add(new UnitListSetter("ft/s",3028084));
            SpeedList.add(new UnitListSetter("ft/h",11811.0236));
            SpeedList.add(new UnitListSetter("mi/s",0.000621));
            SpeedList.add(new UnitListSetter("mi/h",2.236936));
            SpeedList.add(new UnitListSetter("노트(kn)",1.943844));
            SpeedList.add(new UnitListSetter("마하(mach)",0.002941));

            MileageList = new ArrayList<>();
            MileageList.add(new UnitListSetter("km/l",1));
            MileageList.add(new UnitListSetter("mi/g",2.352146));
            MileageList.add(new UnitListSetter("l/100km",100));

            DataList = new ArrayList<>();
            DataList.add(new UnitListSetter("비트(bit)",858993459));
            DataList.add(new UnitListSetter("바이트(B)",107374182));
            DataList.add(new UnitListSetter("킬로바이트(KB)",104857.6));
            DataList.add(new UnitListSetter("메가바이트(MB)",102.4));
            DataList.add(new UnitListSetter("기가바이트(GB)",0.1));
            DataList.add(new UnitListSetter("테라바이트(TB)",0.000098));
            DataList.add(new UnitListSetter("페타바이트(PB)",0.00000009537));
            DataList.add(new UnitListSetter("엑사바이트(EB)",0.00000000009));
        }

        class UnitListSetter{

            String title;
            double value;

            UnitListSetter(String title,double value){
                this.title = title;
                this.value = value;
            }

            public double getValue() {
                return this.value;
            }

            public String getTitle() {
                return this.title;
            }
        }

        public double getWeight(String k,String type, String type2){
            double result = 0;

            double a=0,b=0;

            for(int  i = 0 ; i < WeightList.size(); i++){

                if(type.equals(WeightList.get(i).getTitle().toString())){

                    a = WeightList.get(i).getValue();


                }
                if (type2.equals(WeightList.get(i).getTitle().toString())){
                    b = WeightList.get(i).getValue();
                }

            }

            if(!k.isEmpty()) {
                result = (Double.parseDouble(k) * b) / a;
            }else{

            }

            return result;
        }

    public double getVolume(String k,String type, String type2){
        double result = 0;

        double a=0,b=0;

        for(int  i = 0 ; i < VolumeList.size(); i++){

            if(type.equals(VolumeList.get(i).getTitle().toString())){

                a = VolumeList.get(i).getValue();


            }
            if (type2.equals(VolumeList.get(i).getTitle().toString())){
                b = VolumeList.get(i).getValue();
            }

        }

        if(!k.isEmpty()) {
            result = (Double.parseDouble(k) * b) / a;
        }else{

        }

        return result;
    }

    public double getPressure(String k,String type, String type2){
        double result = 0;

        double a=0,b=0;

        for(int  i = 0 ; i < PressureList.size(); i++){

            if(type.equals(PressureList.get(i).getTitle().toString())){

                a = PressureList.get(i).getValue();


            }
            if (type2.equals(PressureList.get(i).getTitle().toString())){
                b = PressureList.get(i).getValue();
            }

        }

        if(!k.isEmpty()) {
            result = (Double.parseDouble(k) * b) / a;
        }else{

        }

        return result;
    }

    public double getSpeed(String k,String type, String type2){
        double result = 0;

        double a=0,b=0;

        for(int  i = 0 ; i < SpeedList.size(); i++){

            if(type.equals(SpeedList.get(i).getTitle().toString())){

                a = SpeedList.get(i).getValue();


            }
            if (type2.equals(SpeedList.get(i).getTitle().toString())){
                b = SpeedList.get(i).getValue();
            }

        }

        if(!k.isEmpty()) {
            result = (Double.parseDouble(k) * b) / a;
        }else{

        }

        return result;
    }

    public double getMlieage(String k,String type, String type2){
        double result = 0;

        double a=0,b=0;

        for(int  i = 0 ; i < MileageList.size(); i++){

            if(type.equals(MileageList.get(i).getTitle().toString())){

                a = MileageList.get(i).getValue();


            }
            if (type2.equals(MileageList.get(i).getTitle().toString())){
                b = MileageList.get(i).getValue();
            }

        }

        if(!k.isEmpty()) {
            result = (Double.parseDouble(k) * b) / a;
        }else{

        }

        return result;
    }

    public double getData(String k,String type, String type2){
        double result = 0;

        double a=0,b=0;

        for(int  i = 0 ; i < DataList.size(); i++){

            if(type.equals(DataList.get(i).getTitle().toString())){

                a = DataList.get(i).getValue();


            }
            if (type2.equals(DataList.get(i).getTitle().toString())){
                b = DataList.get(i).getValue();
            }

        }

        if(!k.isEmpty()) {
            result = (Double.parseDouble(k) * b) / a;
        }else{

        }

        return result;
    }

        public double getAreaConvert(String k, String type,String type2){
            double result = 0;

            double a=0,b=0;

            for(int  i = 0 ; i < AreaList.size(); i++){

                if(type.equals(AreaList.get(i).getTitle().toString())){

                    a = AreaList.get(i).getValue();


                }
                if (type2.equals(AreaList.get(i).getTitle().toString())){
                    b = AreaList.get(i).getValue();
                }

            }

            if(!k.isEmpty()) {
                result = (Double.parseDouble(k) * b) / a;
            }else{

            }

            return result;

        }

        //길이 계산
        public double getAtoB(String k, String type,String type2){
            double result = 0;

            double a=0,b=0;

                for(int  i = 0 ; i < LengthList.size(); i++){

                    if(type.equals(LengthList.get(i).getTitle().toString())){

                         a = LengthList.get(i).getValue();


                    }
                    if (type2.equals(LengthList.get(i).getTitle().toString())){
                         b = LengthList.get(i).getValue();
                    }

                }

                if(!k.isEmpty()) {
                    result = (Double.parseDouble(k) * b) / a;
                }else{

                }

            return result;
        }




}
