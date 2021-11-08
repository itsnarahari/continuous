package com.test.boot.praveen;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDateTime;
import java.util.*;

public class RemoteOps {

    public static void main(String[] args) throws JsonProcessingException {

        List<RemoteOperation> remoteOps1 = Arrays.asList(
                new RemoteOperation("2020-06-29T11:32:53","v1"),
                new RemoteOperation("2020-06-30T11:32:54","v2"),
                new RemoteOperation("2020-06-05T11:32:53","v3"),
                new RemoteOperation("2020-05-09T11:32:53","v4"),
                new RemoteOperation("2020-06-30T11:32:53","v5")
                );

        List<RemoteOperation> remoteOps2 = Arrays.asList(
                new RemoteOperation("2020-04-29T11:32:53","v1"),
                new RemoteOperation("2020-06-30T11:32:54","v2"),
                new RemoteOperation("2020-03-05T11:32:53","v3"),
                new RemoteOperation("2020-05-09T11:32:53","v4"),
                new RemoteOperation("2020-01-30T11:32:53","v5"),
                new RemoteOperation("2021-01-30T11:32:53","v8")

        );
        List<RemoteOperation> list = new ArrayList<>();
        list.addAll(remoteOps1);
        list.addAll(remoteOps2);

        Collections.sort(list, (t1, t2) -> {
            LocalDateTime localDateTime1 = LocalDateTime.parse(t1.getStartTime());
            LocalDateTime localDateTime2 = LocalDateTime.parse(t2.getStartTime());

            if (localDateTime1.isBefore(localDateTime2))
                return -1;
            else if (localDateTime1.equals(localDateTime2))
                return 0;
            else
                return 1;
        });
        List<RemoteOperation> finalResponse= list.subList(0,1);

    }
}
