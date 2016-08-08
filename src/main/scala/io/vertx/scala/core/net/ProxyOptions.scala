/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.core.net

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Proxy options for a net client or a net client.
  */

class ProxyOptions(val java: io.vertx.core.net.ProxyOptions) {
          def setHost(value:String) = {
          java.setHost(value)
          this
  }
            def getHost = {
    java.getHost()
  }
            def setPassword(value:String) = {
          java.setPassword(value)
          this
  }
            def getPassword = {
    java.getPassword()
  }
            def setPort(value:Int) = {
          java.setPort(value)
          this
  }
            def getPort = {
    java.getPort()
  }
            def setType(value:io.vertx.core.net.ProxyType) = {
          java.setType(value)
          this
  }
            def getType = {
    java.getType()
  }
            def setUsername(value:String) = {
          java.setUsername(value)
          this
  }
            def getUsername = {
    java.getUsername()
  }
  }
object ProxyOptions {
  type ProxyOptionsJava = io.vertx.core.net.ProxyOptions
  def fromJson(json: JsonObject):ProxyOptions = {
    new ProxyOptions(new ProxyOptionsJava(json))
  }
}
